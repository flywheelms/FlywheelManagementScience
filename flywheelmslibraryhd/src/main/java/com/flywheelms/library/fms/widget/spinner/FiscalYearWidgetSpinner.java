/* @(#)FiscalYearWidgetSpinner.java
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

package com.flywheelms.library.fms.widget.spinner;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;

import com.flywheelms.library.fmm.FmmDatabaseMediator;
import com.flywheelms.library.fmm.node.impl.enumerator.FmmNodeDefinition;
import com.flywheelms.library.fmm.node.impl.governable.FiscalYear;
import com.flywheelms.library.fmm.node.impl.governable.FlywheelMilestone;
import com.flywheelms.library.fmm.node.impl.governable.ProjectAsset;
import com.flywheelms.library.fmm.node.impl.governable.StrategicMilestone;
import com.flywheelms.library.fms.widget.FmmHeadlineNodeWidgetSpinner;
import com.flywheelms.library.gcg.interfaces.GcgGuiable;

public class FiscalYearWidgetSpinner extends FmmHeadlineNodeWidgetSpinner {
	
	// primary parent is FmsOrganization, obtained using FmmDatabaseMediator.getActiveMediator().getFmmOwner()
	private StrategicMilestone strategicMilestoneException;  // primary child
	private ProjectAsset projectAssetException; // primary child, primary grandchild
	private FlywheelMilestone flywheelMilestonException;  // secondary child
	private FiscalYear fiscalYearException;
	
	public FiscalYearWidgetSpinner(Context aContext, AttributeSet anAttributeSet) {
		super(aContext, anAttributeSet);
	}

	@Override
	protected String getLabelText() {
		return FmmNodeDefinition.FISCAL_YEAR.getLabelText();
	}

	@Override
	public void setup() {
		super.setup();
	}

	// filter_id__PRIMARY_PARENT
	// filter_id__PRIMARY_PARENT__PRIMARY_CHILD__MOVE_TARGET
	// filter_id__PRIMARY_PARENT__SECONDARY_CHILD__MOVE_TARGET
	public void updateSpinnerData(FiscalYear aFiscalYearException) {
		this.fiscalYearException = aFiscalYearException;
		super.updateSpinnerData();
	}

	@Override
	//filter_id__PRIMARY_PARENT
	protected ArrayList<? extends GcgGuiable> getPrimaryParentGuiableList() {
		return FmmDatabaseMediator.getActiveMediator().getFiscalYearList(
				FmmDatabaseMediator.getActiveMediator().getFmmOwner(), this.fiscalYearException );
	}
	
	
	// filter_id__PRIMARY_PARENT__PRIMARY_CHILD__MOVE_TARGET
	@Override
	protected ArrayList<? extends GcgGuiable> getPrimaryParentPrimaryChildMoveTargetGuiableList() {  // StrategicMilestone move target
		return FmmDatabaseMediator.getActiveMediator().getFiscalYearList(
				FmmDatabaseMediator.getActiveMediator().getFmmOwner(), this.fiscalYearException );
	}
	
	// filter_id__PRIMARY_PARENT__PRIMARY_CHILD__PRIMARY_CHILD__MOVE_TARGET
	public void updateSpinnerData(StrategicMilestone aStrategicMilestoneException) {
		this.strategicMilestoneException = aStrategicMilestoneException;
		super.updateSpinnerData();
	}
	
	// filter_id__PRIMARY_PARENT__PRIMARY_CHILD__PRIMARY_CHILD__MOVE_TARGET
	@Override
	protected ArrayList<? extends GcgGuiable> getPrimaryParentPrimaryChildPrimaryChildMoveTargetGuiableList() { // ProjectAsset move target
		return FmmDatabaseMediator.getActiveMediator().listFiscalYearForProjectAssetMoveTarget(
				FmmDatabaseMediator.getActiveMediator().getFmmOwner(), this.strategicMilestoneException );
	}
	
	// filter_id__PRIMARY_PARENT__PRIMARY_CHILD__PRIMARY_CHILD__PRIMARY_CHILD__MOVE_TARGET
	public void updateSpinnerData(ProjectAsset aProjectAssetException) {
		this.projectAssetException = aProjectAssetException;
		super.updateSpinnerData();
	}
	
	// filter_id__PRIMARY_PARENT__PRIMARY_CHILD__PRIMARY_CHILD__PRIMARY_CHILD__MOVE_TARGET
	@Override
	protected ArrayList<? extends GcgGuiable> getPrimaryParentPrimaryChildPrimaryChildPrimaryChildMoveTargetGuiableList() { // WorkPackage move target
		return FmmDatabaseMediator.getActiveMediator().listFiscalYearForWorkPackageMoveTarget(
				FmmDatabaseMediator.getActiveMediator().getFmmOwner(), this.projectAssetException );
	}
	
	// filter_id__PRIMARY_PARENT__SECONDARY_CHILD__MOVE_TARGET
	@Override
	protected ArrayList<? extends GcgGuiable> getPrimaryParentSecondaryChildMoveTargetGuiableList() { // FlywheelMilestone move target
		return FmmDatabaseMediator.getActiveMediator().getFiscalYearList(
				FmmDatabaseMediator.getActiveMediator().getFmmOwner(), this.fiscalYearException );
	}

	// filter_id__SECONDARY_PARENT__PRIMARY_CHILD__MOVE_TARGET
	// filter_id__PRIMARY_PARENT__SECONDARY_CHILD__SECONDARY_CHILD__MOVE_TARGET
	public void updateSpinnerData(FlywheelMilestone aFlywheelMilestonException) { // WorkPackage or WorkPlan move target
		this.flywheelMilestonException = aFlywheelMilestonException;
		super.updateSpinnerData();
	}

	public boolean selectNextYear(int aYearInteger) {
		return selectNextYear(aYearInteger + "");
	}

	public boolean selectNextYear(String aYearString) {
		int theInt = Integer.parseInt(aYearString);
		String theNextYear = theInt + 1 + "";
		for(GcgGuiable theGcgGuiable : this.gcgGuiableList) {
			if(theGcgGuiable.getDataText().equals(theNextYear)) {
				int theNextYearPosition = this.gcgGuiableList.indexOf(theGcgGuiable);
				if(theNextYearPosition < this.gcgGuiableList.size() && theNextYearPosition > -1) {
					this.spinner.setSelection(theNextYearPosition);
					return true;
				}
			}
		}
		return false;
	}

	public boolean selectPreviousYear(int aYearInteger) {
		return selectPreviousYear(aYearInteger + "");
	}

	public boolean selectPreviousYear(String aYearString) {
		int theInt = Integer.parseInt(aYearString);
		String thePreviousYear = theInt - 1 + "";
		for(GcgGuiable theGcgGuiable : this.gcgGuiableList) {
			if(theGcgGuiable.getDataText().equals(thePreviousYear)) {
				int thePreviousYearPosition = this.gcgGuiableList.indexOf(theGcgGuiable);
				if(thePreviousYearPosition < this.gcgGuiableList.size() && thePreviousYearPosition > -1) {
					this.spinner.setSelection(thePreviousYearPosition);
					return true;
				}
			}
		}
		return false;
	}
	
	public FiscalYear getFiscalYear() {
		return (FiscalYear) getSelectedItem();
	}
	
	public String getFiscalYearNumberAsString() {
		return ((FiscalYear) getSelectedItem()).getYearString();
	}
	
	public int getFiscalYearNumberAsInt() {
		return ((FiscalYear) getSelectedItem()).getYearAsInt();
	}

}
