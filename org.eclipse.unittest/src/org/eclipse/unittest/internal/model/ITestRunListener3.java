/*******************************************************************************
 * Copyright (c) 2000, 2017 IBM Corporation and others.
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
package org.eclipse.unittest.internal.model;

public interface ITestRunListener3 {

	/**
   	 * Status constant indicating that a test passed (constant value 0).
 	 */
 	public static final int STATUS_OK= 0;
 	/**
	 * Status constant indicating that a test had an error an unanticipated
	 * exception (constant value 1).
 	 */
 	public static final int STATUS_ERROR= 1;
 	/**
	 * Status constant indicating that a test failed an assertion
	 * (constant value 2).
	 */
 	public static final int STATUS_FAILURE= 2;
 	/**
 	 * A test run has started.
 	 *
 	 * @param testCount the number of individual tests that will be run
 	 */
	public void testRunStarted(int testCount);
	/**
 	 * A test run has ended.
	 *
	 * @param elapsedTime the total elapsed time of the test run
	 */
	public void testRunEnded(long elapsedTime);
	/**
	 * A test run has been stopped prematurely.
	 *
 	 * @param elapsedTime the time elapsed before the test run was stopped
	 */
	public void testRunStopped(long elapsedTime);
	/**
	 * An individual test has started.
	 *
	 * @param testId a unique Id identifying the test
	 * @param testName the name of the test that started
	 */
	public void testStarted(String testId, String testName);
	/**
	 * An individual test has ended.
	 *
	 * @param testId a unique Id identifying the test
	 * @param testName the name of the test that ended
	 */
	public void testEnded(String testId, String testName);


	/**
	 * The VM instance performing the tests has terminated.
	 */
	public void testRunTerminated();

	/**
	 * Information about a member of the test suite that is about to be run. The format of the
	 * string is:
	 *
	 * <pre>
	 *  testId,testName,isSuite,testcount,isDynamicTest,parentId,displayName,parameterTypes,uniqueId
	 *
	 *  @param testId: a unique id for the test
	 *  @param testName: the name of the test
	 *  @param isSuite: true or false depending on whether the test is a suite
	 *  @param testCount: an integer indicating the number of tests
	 *  @param isDynamicTest: true or false
	 *  @param parentId: the unique testId of its parent if it is a dynamic test, otherwise can be "-1"
	 *  @param displayName: the display name of the test
	 *  @param parameterTypes: comma-separated list of method parameter types if applicable, otherwise an empty string
	 *  @param uniqueId: the unique ID of the test provided by JUnit launcher, otherwise an empty string
	 *
	 *  Example: 324968,testPass(junit.tests.MyTest),false,1,false,-1,A simple test case,&quot;&quot;,&quot;&quot;
	 * </pre>
	 */

	public void testTreeEntry(String testId, String testName, boolean isSuite, int testCount, boolean isDynamicTest,
			String parentId, String displayName, String[] parameterTypes, String uniqueId);

	/**
	 * An individual test has failed with a stack trace.
	 *
	 * @param status the outcome of the test; one of
	 *        {@link #STATUS_ERROR STATUS_ERROR} or
	 *        {@link #STATUS_FAILURE STATUS_FAILURE}
	 * @param testId a unique Id identifying the test
	 * @param testName the name of the test that failed
	 * @param trace the stack trace
	 * @param expected the expected value
	 * @param actual the actual value
	 */
	public void testFailed(int status, String testId, String testName, String trace, String expected, String actual);

	/**
	 * An individual test has been rerun.
	 *
	 * @param testId a unique Id identifying the test
	 * @param testClass the name of the test class that was rerun
	 * @param testName the name of the test that was rerun
	 * @param status the outcome of the test that was rerun; one of
	 *        {@link #STATUS_OK}, {@link #STATUS_ERROR}, or
	 *        {@link #STATUS_FAILURE}
	 * @param trace the stack trace in the case of abnormal termination, or the
	 *        empty string if none
	 * @param expected the expected value in case of abnormal termination, or
	 *        the empty string if none
	 * @param actual the actual value in case of abnormal termination, or the
	 *        empty string if none
	 */
	public void testReran(String testId, String testClass, String testName, int status, String trace, String expected, String actual);



}
