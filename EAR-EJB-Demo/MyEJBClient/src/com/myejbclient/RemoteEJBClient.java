
package com.myejbclient;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.myejb.EmployeeManager;
import com.myejb.model.Employee;

public class RemoteEJBClient {

	public static void main(String[] args) throws NamingException {
//		EmployeeManager employeeManager = lookupRemoteStatelessEmployeeManager();
		EmployeeManager employeeManager = (EmployeeManager) lookupRemoteStateless(EmployeeManager.class);
		List<Employee> employees = employeeManager.findAll();

		employees.forEach(System.out::println);
	}

	private static Object lookupRemoteStateless(Class clazz) throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);

		final String appName = "MyEAR";
		final String moduleName = "MyEJB";
		final String distinctName = "";
//		final String beanName = EmployeeManagerBean.class.getSimpleName();
		final String beanName = clazz.getSimpleName()+"Bean";
//		final String viewClassName = EmployeeManager.class.getName();
		final String viewClassName = clazz.getName();

		String ejbCallName = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!"
				+ viewClassName;

		System.out.println(ejbCallName);

		return (EmployeeManager) context.lookup(ejbCallName);
	}

}