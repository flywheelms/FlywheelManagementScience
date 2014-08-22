/* @(#)StrategicMilestoneTargetDateEditDialog.java
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

package com.flywheelms.library.fms.dialog;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;

import com.flywheelms.library.R;
import com.flywheelms.library.fmm.FmmDatabaseMediator;
import com.flywheelms.library.fmm.node.impl.enumerator.FmmNodeDefinition;
import com.flywheelms.library.fmm.node.impl.governable.StrategicMilestone;
import com.flywheelms.library.fmm.node.interfaces.horizontal.FmmHeadlineNode;
import com.flywheelms.library.fms.activity.FmmNodeEditorActivity;
import com.flywheelms.library.fms.treeview.filter.FmsTreeViewAdapter;
import com.flywheelms.library.fms.widget.text_view.FmmNodeTypeWidgetTextView;
import com.flywheelms.library.fms.widget.text_view.HeadlineWidgetTextView;
import com.flywheelms.library.fms.widget.text_view.TargetDateWidgetTextView;
import com.flywheelms.library.gcg.GcgActivity;
import com.flywheelms.library.gcg.helper.GcgHelper;
import com.flywheelms.library.gcg.widget.GcgOnSetTextListener;
import com.flywheelms.library.gcg.widget.GcgWidget;
import com.flywheelms.library.gcg.widget.date.GcgDateHelper;
import com.flywheelms.library.gcg.widget.date.GcgWidgetDatePicker;
import com.flywheelms.library.gcg.widget.date.GcgWidgetMonthSpinner;

public class StrategicMilestoneTargetDateEditDialog extends FmsCancelOkDialog {

	private StrategicMilestone strategicMilestone;
	private FmsTreeViewAdapter treeViewAdapter;
	private FmmNodeEditorActivity nodeEditorActivity;
	protected FmmNodeTypeWidgetTextView fmmNodeTypeWidget;
	protected HeadlineWidgetTextView headlineWidget;
	protected TargetDateWidgetTextView originalTargetDateString;
	protected RadioButton monthEndChoice;
	protected GcgWidgetMonthSpinner monthSpinner;
	protected RadioButton specificDateChoice;
	protected GcgWidgetDatePicker datePicker;
	protected CheckBox enableReversePlanningCheckBox;

	public StrategicMilestoneTargetDateEditDialog(GcgActivity aGcgActivity, FmsTreeViewAdapter aTreeViewAdapter, FmmHeadlineNode aHeadlineNode ) {
		super(aGcgActivity, aHeadlineNode.getFmmNodeDefinition());
		this.treeViewAdapter = aTreeViewAdapter;
		this.nodeEditorActivity = (FmmNodeEditorActivity) this.headlineNode;
		this.headlineNode = aHeadlineNode;
		this.strategicMilestone = (StrategicMilestone) aHeadlineNode;
		initializeDialogBodyLate();
	}

	public StrategicMilestoneTargetDateEditDialog(GcgActivity aGcgActivity, FmmHeadlineNode aHeadlineNode ) {
		super(aGcgActivity, aHeadlineNode.getFmmNodeDefinition());
		this.headlineNode = aHeadlineNode;
		this.strategicMilestone = (StrategicMilestone) aHeadlineNode;
		initializeDialogBodyLate();
	}

	public StrategicMilestoneTargetDateEditDialog(GcgActivity aGcgActivity, FmmNodeDefinition anFmmNodeDefinition, FmmHeadlineNode aHeadlineNode ) {
		super(aGcgActivity, anFmmNodeDefinition);
		this.headlineNode = aHeadlineNode;
		this.strategicMilestone = (StrategicMilestone) aHeadlineNode;
		initializeDialogBodyLate();
	}

	@Override
	protected boolean deferredDialogInitialization() {
		return true;
	}

	@Override
	protected int getDialogTitleStringResourceId() {
		return R.string.strategic_milestone__target_date__edit;
	}

	@Override
	protected int getDialogTitleIconResourceId() {
		return this.fmmNodeDefinition.getDialogDrawableResourceId();
	}

	@Override
	protected int getCustomDialogContentsResourceId() {
		return R.layout.strategic_milestone__target_date__edit__dialog;
	}

	protected void initializeDialogBodyLate() {
		super.initializeDialogBody();
		this.fmmNodeTypeWidget = (FmmNodeTypeWidgetTextView) this.dialogBodyView.findViewById(R.id.fmm_node__type);
		this.fmmNodeTypeWidget.setText(this.fmmNodeDefinition.getLabelTextResourceId());
		this.headlineWidget = (HeadlineWidgetTextView) this.dialogBodyView.findViewById(R.id.headline);
		this.headlineWidget.setText(this.headlineNode.getHeadline());
		this.originalTargetDateString = (TargetDateWidgetTextView) this.dialogBodyView.findViewById(R.id.original_target_date);
		this.originalTargetDateString.setText(this.strategicMilestone.getTargetDateString());
		this.monthSpinner = (GcgWidgetMonthSpinner) this.dialogBodyView.findViewById(R.id.gcg__month__spinner);
		this.datePicker = (GcgWidgetDatePicker) this.dialogBodyView.findViewById(R.id.gcg__date_chooser);
		this.datePicker.setGcgActivity(this.gcgActivity);
		this.datePicker.setOnSetTextListener(new GcgOnSetTextListener() {
			
			@Override
			public void onSetText(GcgWidget aGcgWidget, String aTextString) {
				manageButtonState();
			}
		} );
		this.datePicker.setEnabled(false);
		this.enableReversePlanningCheckBox = (CheckBox) this.dialogBodyView.findViewById(R.id.enable_reverse_planning);
		this.enableReversePlanningCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					StrategicMilestoneTargetDateEditDialog.this.updateReversePlanningOptions();
			}
		});
		updateReversePlanningOptions();
		this.monthEndChoice = (RadioButton) this.dialogBodyView.findViewById(R.id.choice__month_end);
		this.monthEndChoice.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked) {
					StrategicMilestoneTargetDateEditDialog.this.monthSpinner.setEnabled(true);
					StrategicMilestoneTargetDateEditDialog.this.datePicker.setEnabled(false);
					StrategicMilestoneTargetDateEditDialog.this.buttonOk.setVisibility(View.VISIBLE);
				}
			}
		});
		this.specificDateChoice = (RadioButton) this.dialogBodyView.findViewById(R.id.choice__specific_date);
		this.specificDateChoice.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked) {
					StrategicMilestoneTargetDateEditDialog.this.monthSpinner.setEnabled(false);
					StrategicMilestoneTargetDateEditDialog.this.datePicker.setEnabled(true);
					StrategicMilestoneTargetDateEditDialog.this.buttonOk.setVisibility(
							StrategicMilestoneTargetDateEditDialog.this.datePicker.isMinimumInput() ? View.VISIBLE : View.INVISIBLE );
				}
			}
		});
		if(this.strategicMilestone.getTargetMonthEnd() != 0) {
			this.monthSpinner.setSelection(this.strategicMilestone.getTargetMonthEnd() - 1);
		} else if(! this.strategicMilestone.getTargetDate().equals(GcgDateHelper.NULL_DATE)) {
			this.datePicker.setOriginalDate(this.strategicMilestone.getTargetDate(), true);
			this.datePicker.setEnabled(true);
			this.specificDateChoice.setChecked(true);
		}
		manageButtonState();
	}

	private void updateReversePlanningOptions() {
		if(this.enableReversePlanningCheckBox.isChecked()) {
			this.datePicker.setYearRange(this.strategicMilestone.getFiscalYear().getYearAsInt());
			this.monthSpinner.setMonthRangeAll();
		} else {
			this.datePicker.setRemainderOfYearRange(this.strategicMilestone.getFiscalYear().getYearAsInt());
			this.monthSpinner.setMonthRangeYearRemaining(this.strategicMilestone.getFiscalYear().getYearAsInt());
		}
	}

	@Override
	protected void manageButtonState() {
		if(this.buttonOk == null) {
			return;
		}
		this.buttonOk.setVisibility(this.specificDateChoice.isChecked() && ! this.datePicker.isMinimumInput() ?
				View.INVISIBLE : View.VISIBLE );
	}

	@Override
	protected void onClickButtonOk() {
		updateTargetDate();
		if(this.monthEndChoice.isChecked()) {
			if(this.treeViewAdapter != null) {
				this.treeViewAdapter.updateSecondaryHeadline(this.strategicMilestone.getTargetDateString());
			} else {
				this.nodeEditorActivity.updateTargetDate(this.strategicMilestone);
			}
		}
		this.gcgActivity.stopDialog();
	}

	private void updateTargetDate() {
		if(this.monthEndChoice.isChecked()) {
			this.strategicMilestone.setTargetMonthEnd(this.monthSpinner.getSelectedItemPosition() + 1);
			this.strategicMilestone.setTargetDate(GcgDateHelper.NULL_DATE);
		} else {
			this.strategicMilestone.setTargetMonthEnd(0);
			this.strategicMilestone.setTargetDate(this.datePicker.getSelectedDate());
		}
		if(FmmDatabaseMediator.getActiveMediator().updateTargetDate(this.strategicMilestone, true)) {
			if(this.treeViewAdapter != null) {
				this.treeViewAdapter.updateSecondaryHeadline(this.strategicMilestone.getTargetDateString());
			} else {
				this.nodeEditorActivity.updateTargetDate(this.headlineNode);
			}
			GcgHelper.makeToast("Target date updated.");
		} else {
			GcgHelper.makeToast("ERROR:  Unable to update target date for " + this.fmmNodeTypeWidget.getText() + " " + this.headlineNode.getHeadline());
		}
	}
	
	@Override
	public void onWidgetDataChangeListener(@SuppressWarnings("unused") int aResourceId) {
		manageButtonState();
	}

}
