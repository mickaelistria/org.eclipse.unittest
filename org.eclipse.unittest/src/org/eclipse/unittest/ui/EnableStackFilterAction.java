/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
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


import org.eclipse.unittest.UnitTestPlugin;
import org.eclipse.unittest.internal.UnitTestPreferencesConstants;

import org.eclipse.jface.action.Action;

import org.eclipse.ui.PlatformUI;

/**
 * Action to enable/disable stack trace filtering.
 */
public class EnableStackFilterAction extends Action {

	private FailureTraceUIBlock fView;

	public EnableStackFilterAction(FailureTraceUIBlock view) {
		super(Messages.EnableStackFilterAction_action_label);
		setDescription(Messages.EnableStackFilterAction_action_description);
		setToolTipText(Messages.EnableStackFilterAction_action_tooltip);

		setDisabledImageDescriptor(UnitTestPlugin.getImageDescriptor("dlcl16/cfilter.png")); //$NON-NLS-1$
		setHoverImageDescriptor(UnitTestPlugin.getImageDescriptor("elcl16/cfilter.png")); //$NON-NLS-1$
		setImageDescriptor(UnitTestPlugin.getImageDescriptor("elcl16/cfilter.png")); //$NON-NLS-1$
		PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IUnitTestHelpContextIds.ENABLEFILTER_ACTION);

		fView= view;
		setChecked(UnitTestPreferencesConstants.getFilterStack());
	}

	@Override
	public void run() {
		UnitTestPreferencesConstants.setFilterStack(isChecked());
		fView.refresh();
	}
}
