/*******************************************************************************
 * Copyright (c) 2016 IBM Corporation and others.
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
package org.eclipse.unittest.ui;

import org.eclipse.jdt.debug.ui.console.JavaStackTraceConsoleFactory;
import org.eclipse.unittest.UnitTestPlugin;
import org.eclipse.unittest.internal.model.TestElement;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

/**
 * Action to show the stack trace of a failed test from JUnit view's failure trace in debug's Java
 * stack trace console.
 */
public class ShowStackTraceInConsoleViewAction extends Action {

	private FailureTrace fView;

	private JavaStackTraceConsoleFactory fFactory;

	public ShowStackTraceInConsoleViewAction(FailureTrace view) {
		super(Messages.ShowStackTraceInConsoleViewAction_label, IAction.AS_PUSH_BUTTON);
		setDescription(Messages.ShowStackTraceInConsoleViewAction_description);
		setToolTipText(Messages.ShowStackTraceInConsoleViewAction_tooltip);

		setHoverImageDescriptor(UnitTestPlugin.getImageDescriptor("elcl16/open_console.png")); //$NON-NLS-1$
		setImageDescriptor(UnitTestPlugin.getImageDescriptor("elcl16/open_console.png")); //$NON-NLS-1$

		fView= view;
	}

	@Override
	public void run() {
		TestElement failedTest= fView.getFailedTest();
		String stackTrace= failedTest.getTrace();
		if (stackTrace != null) {
			if (fFactory == null) {
				fFactory= new JavaStackTraceConsoleFactory();
			}
			fFactory.openConsole(stackTrace);
		}
	}
}
