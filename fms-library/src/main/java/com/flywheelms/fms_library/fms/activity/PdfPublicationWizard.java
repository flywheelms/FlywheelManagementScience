/* @(#)PdfPublicationActivity.java
** 
** Copyright (C) 2012 by Steven D. Stamps
**
**             Trademarks & Copyrights
** Flywheel Management Science(TM), Flywheel Management Model(TM),
** Flywheel Story Editor(TM) and FlywheelMS(TM) are exclusive trademarks
** of Steven D. Stamps and may only be used freely for the purpose of
** identifying the unforked version of this software.  Subsequent forks
** may not use these trademarks.  All other rights are reserved.
**
** DecKanGL (Decorated Kanban Glyph Language) and TribKn (Tribal Knowledge)
** are also exclusive trademarks of Steven D. Stamps.  These may be used
** freely within the unforked FlywheelMS application and documentation.
** All other rights are reserved.
**
** gConGUI (game Controller Graphical User Interface) is an exclusive
** trademark of Steven D. Stamps.  This trademark may be used freely
** within the unforked FlywheelMS application and documentation.
** All other rights are reserved.
**
** Trademark information is available at
** <http://www.flywheelms.com/trademarks>
**
** Flywheel Management Science(TM) is a copyrighted body of management
** metaphors, governance processes, and leadership techniques that is
** owned by Steven D. Stamps.  These copyrighted materials may be freely
** used, without alteration, by the community (users and developers)
** surrounding this GPL3-licensed software.  Additional copyright
** information is available at <http://www.flywheelms.org/copyrights>
**
**              GPL3 Software License
** This program is free software: you can use it, redistribute it and/or
** modify it under the terms of the GNU General Public License, version 3,
** as published by the Free Software Foundation. This program is distributed
** in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
** even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
** PURPOSE.  See the GNU General Public License for more details. You should
** have received a copy of the GNU General Public License, in a file named
** COPYING, along with this program.  If you cannot find your copy, see
** <http://www.gnu.org/licenses/gpl-3.0.html>.
*/

package com.flywheelms.fms_library.fms.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.flywheelms.gcongui.gcg.context.GcgNavigationTarget;
import com.flywheelms.fms_library.R;
import com.flywheelms.fms_library.fmm.node.NodeId;
import com.flywheelms.fms_library.fmm.node.impl.enumerator.FmmNodeDefinition;
import com.flywheelms.fms_library.fms.helper.FmsActivityHelper;
import com.flywheelms.fms_library.fms.helper.FmsHelpIndex;
import com.flywheelms.fms_library.fms.wizard.FmsNodePublishingWizardStepFlipper;

public class PdfPublicationWizard extends FmsNodeWizardActivity {
	
	private FmsNodePublishingWizardStepFlipper wizardStepFlipper;
	private NodeId pdfPublicationNodeId;

	public PdfPublicationWizard() {
		super(FmsHelpIndex.PDF_PUBLICATION_WIZARD);
	}
	
	@Override
	public void onCreate(Bundle aSavedInstanceState) {
	    super.onCreate(aSavedInstanceState);
	    this.wizardStepFlipper = (FmsNodePublishingWizardStepFlipper) findViewById(R.id.gcg__wizard__step_flipper);
	    this.pdfPublicationNodeId = new NodeId(getDisplayedFmmNodeDefinition().getNodeTypeCode());
	}

	@Override
	protected int getContentViewResourceId() {
		return R.layout.fmm_node__publication__wizard;
	}

    protected boolean pruneLastApplicationContextBreadcrumb() {
        return true;
    }

	@Override
	protected void onActivityResult(int aRequestCode, int aResultCode, Intent anIntent) {
		if(anIntent == null) {
			return;
		}
		if(aResultCode == GcgNavigationTarget.request_code__NAVIGATE) {
			processGcgApplicationContextNavigationIntent(anIntent);
			return;
		}
		if(aRequestCode == FmsActivityHelper.request_code__ANDROID_CONTACT_PICKER) {
			if(aResultCode != Activity.RESULT_CANCELED) {
				this.wizardStepFlipper.getWizardStepView2().getAndroidContactWidgetListView().onObjectPickerResult(anIntent);
			}
			return;
		} else if(aRequestCode == FmsActivityHelper.request_code__ANDROID_CONTACT_EDITOR) {
			if(aResultCode != Activity.RESULT_CANCELED) {
				this.wizardStepFlipper.getWizardStepView2().getAndroidContactWidgetListView().onObjectEditorResult(anIntent);
			}
			return;
		} else if(aRequestCode == FmmNodeDefinition.COMMUNITY_MEMBER.getNodePickerActivityRequestCode()) {
			if(aResultCode != Activity.RESULT_CANCELED) {
				this.wizardStepFlipper.getWizardStepView2().getCommunityMemberWidgetListView().onObjectPickerResult(anIntent);
			}
			return;
		} else if(aRequestCode == FmmNodeDefinition.COMMUNITY_MEMBER.getNodeEditorActivityRequestCode()) {
			if(aResultCode != Activity.RESULT_CANCELED) {
				this.wizardStepFlipper.getWizardStepView2().onCommunityMemberEditorResult(this, anIntent);
			}
			return;
		} else if(aRequestCode == FmsActivityHelper.request_code__PRINTER_INSTALLATION) {
			if(aResultCode != Activity.RESULT_CANCELED) {
				this.wizardStepFlipper.postPrinterInstallationPrint();
			}
			return;
		}
		super.onActivityResult(aRequestCode, aResultCode, anIntent);
	}

	@Override
	protected String getBreadcrumbHeadline() {
		return "PDF Publication";
	}

	@Override
	protected FmmNodeDefinition getDisplayedFmmNodeDefinition() {
		return FmmNodeDefinition.PDF_PUBLICATION;
	}

	@Override
	protected String getBreadcrumbTargetNodeIdString() {
		return getPdfPublicationNodeIdString();
	}

	private String getPdfPublicationNodeIdString() {
		return this.pdfPublicationNodeId.getNodeIdString();
	}

}