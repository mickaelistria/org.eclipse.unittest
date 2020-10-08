/*******************************************************************************
 * Copyright (c) 2020 Red Hat Inc. and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Red Hat Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.unittest.launcher;

import org.eclipse.unittest.internal.model.TestRunSession;

import org.eclipse.debug.core.ILaunch;

/**
 * An interface to be implemented by a Test Runner Client. Such implementation
 * takes care of placing the right listeners got a given {@link TestRunSession}
 * (usually received in the constructor) and to react to the various test engine
 * events (can be notifications via some network, reading standard output....)
 * by sending notifications to the ITestRunListeners.
 */
public interface ITestRunnerClient {

	/**
	 * Indicates if a test run is in progress and still worth being watched.
	 *
	 * @return returns true in case of a test run in progress, otherwise false
	 */
	boolean isRunning();

	/**
	 * Requests to stop the remote test run. Usually requested by user; so should
	 * stop the test runner client (usually calling {@link #disconnect()} and also
	 * related test specific closeable objects like an underlying {@link ILaunch}
	 * (unless launch is configured to be kept alive).
	 */
	void stopTest();

	/**
	 * Disconnects this test runner client; this is typically happening when a test
	 * run session is marked as terminated.
	 */
	void disconnect();

}
