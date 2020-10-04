/*******************************************************************************
 * Copyright (c) 2020 Red Hat Inc. and others
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.unittest.internal.model;

public interface ITestRunSessionReport {

	/**
	 * Returns the name of the test run. The name is the name of the launch
	 * configuration use to run this test.
	 *
	 * @return returns the test run name
	 */
	String getTestRunName();

	/**
	 * Returns the number of started test case elements
	 *
	 * @return a number of started test cases
	 */
	int getStartedCount();

	/**
	 * Returns the number of failed test case elements
	 *
	 * @return a number of failed test cases
	 */
	int getFailureCount();

	/**
	 * Returns the number of assumption failures
	 *
	 * @return a number of assumption failures
	 */
	int getAssumptionFailureCount();

	/**
	 * Returns the number of ignored test case elements
	 *
	 * @return a number of ignored test cases
	 */
	int getIgnoredCount();

	/**
	 * Returns the total number of test case elements
	 *
	 * @return a total number of test cases
	 */
	int getTotalCount();

	/**
	 * Returns the number of test case elements with errors
	 *
	 * @return a number of test cases with errors
	 */
	int getErrorCount();

	/**
	 * Indicates if the test run session is starting
	 *
	 * @return <code>true</code> in case of the test session is starting, otherwise
	 *         returns <code>false</code>
	 */
	boolean isStarting();

	/**
	 * Indicates if the test run session is running
	 *
	 * @return <code>true</code> in case of the test session is running, otherwise
	 *         returns <code>false</code>
	 */
	boolean isRunning();

	/**
	 * Indicates if the test run session has been kept alive
	 *
	 * @return <code>true</code> in case of the test session has been kept alive,
	 *         otherwise returns <code>false</code>
	 */
	boolean isKeptAlive();

	/**
	 * Indicates if the test run session has been stopped or terminated
	 *
	 * @return <code>true</code> if the session has been stopped or terminated,
	 *         otherwise returns <code>false</code>
	 */
	boolean isStopped();

	/**
	 * Stops the test run
	 */
	void stopTestRun();
}