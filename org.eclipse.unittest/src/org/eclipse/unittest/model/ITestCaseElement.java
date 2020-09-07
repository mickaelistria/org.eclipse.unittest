/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.unittest.model;

/**
 * Represents a test case element.
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 *
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
public interface ITestCaseElement extends ITestElement {

	/**
	 * Returns the name of the test method.
	 *
	 * @return returns the name of the test method.
	 */
	String getTestMethodName();

	/**
	 * Returns the qualified type name of the class the test is contained in.
	 *
	 * @return the qualified type name of the class the test is contained in.
	 */
	String getTestClassName();

	/**
	 * Sets ignored flag on the test case
	 *
	 * @param ignored an ignored flag value
	 */
	void setIgnored(boolean ignored);

	/**
	 * Indicates if the test case was ignored
	 *
	 * @return true in case of the test case was ignored, otherwise false
	 */
	boolean isIgnored();

	/**
	 * Indicates if the test case is dynamic
	 *
	 * @return true in case of dynamic test case element, otherwise false
	 */
	boolean isDynamicTest();

}
