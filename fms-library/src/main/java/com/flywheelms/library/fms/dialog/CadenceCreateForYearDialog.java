/* @(#)CadenceCreateForYearDialog.java
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
import android.widget.Button;
import android.widget.CheckBox;

import com.flywheelms.gcongui.gcg.activity.GcgActivity;
import com.flywheelms.gcongui.gcg.container.GcgContainerGroupBoxLinear;
import com.flywheelms.library.R;
import com.flywheelms.library.fmm.node.impl.enumerator.FmmNodeDefinition;
import com.flywheelms.library.fmm.node.impl.governable.Cadence;
import com.flywheelms.library.fmm.node.impl.governable.FiscalYear;
import com.flywheelms.library.fms.treeview.filter.FmsTreeViewAdapter;
import com.flywheelms.library.fms.widget.spinner.CadenceDurationWidgetSpinner;
import com.flywheelms.library.fms.widget.spinner.WorkPlanFirstDayOfWeekWidgetSpinner;
import com.flywheelms.library.fms.widget.text_view.FiscalYearWidgetTextView;
import com.flywheelms.library.fms.widget.text_view.HeadlineWidgetTextView;

import java.util.ArrayList;

public class CadenceCreateForYearDialog extends FmsCancelOkDialog {

    FmsTreeViewAdapter treeViewAdapter;
    protected final FiscalYear fiscalYear;
    protected FiscalYearWidgetTextView fiscalYearWidgetTextView;
    protected HeadlineWidgetTextView parentHeadlineWidget;
    protected GcgContainerGroupBoxLinear cadenceParametersLayout;  // cadence duration and holiday slack checkbox and spinner
    protected CadenceDurationWidgetSpinner cadenceDurationSpinner;
    protected CheckBox scheduleHolidayBreaks;
    protected WorkPlanFirstDayOfWeekWidgetSpinner workPlanFirstDayOfWeekWidgetSpinner;
    protected Button previewButton;

    public CadenceCreateForYearDialog(
            GcgActivity aLibraryActivity,
            FmsTreeViewAdapter aTreeViewAdapter,
            FiscalYear aFiscalYear ) {
        super(aLibraryActivity, FmmNodeDefinition.CADENCE);
        this.treeViewAdapter = aTreeViewAdapter;
        this.fiscalYear = aFiscalYear;
        this.fmsDialogExtension.parentHeadlineNode = aFiscalYear;
        initializeDialogBodyLate();
        manageButtonState();
    }

    @Override
    protected int getDialogTitleStringResourceId() {
        return R.string.fms__create_all;
    }

    @Override
    protected int getDialogBodyLayoutResourceId() {
        return R.layout.flywheel_cadence__create_for_year__dialog;
    }

//    @Override
//    protected int getCustomDialogContentsResourceId() {
//        return R.layout.flywheel_cadence__create_for_year__dialog;
//    }

    @Override
    protected void initializeDialogBody() {
        return;
    }

    protected void initializeDialogBodyLate() {
        super.initializeDialogBody();
        this.fiscalYearWidgetTextView = (FiscalYearWidgetTextView) this.dialogBodyView.findViewById(R.id.fiscal_year__text_view);
        this.fiscalYearWidgetTextView.setFiscalYear(this.fiscalYear);
        this.cadenceParametersLayout = (GcgContainerGroupBoxLinear) this.dialogBodyView.findViewById(R.id.group_box__cadence_parameters);
        this.cadenceDurationSpinner = (CadenceDurationWidgetSpinner) this.dialogBodyView.findViewById(R.id.cadence_duration__spinner);
        this.workPlanFirstDayOfWeekWidgetSpinner = (WorkPlanFirstDayOfWeekWidgetSpinner) this.dialogBodyView.findViewById(R.id.work_plan__first_day_of_week__spinner);
        this.previewButton = (Button) this.dialogBodyView.findViewById(R.id.button__preview);
        this.previewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CadenceCreateForYearDialog.this.onClickButtonPreview();
            }
        });
    }

    private void createCadencesForFiscalYear(boolean bOkButtonEvent) {
        // update FiscalYear with Cadence Parameters
        // create Cadence collection
    }

    protected void onClickButtonPreview() {
//        this.gcgActivity.startDialog(new CadencePreviewDialog(
//                this.gcgActivity,
//                this.cadenceDurationSpinner.getSelectedItem().getDataText(),
//                // TODO - send over list of initialized holidays
//                this.workPlanFirstDayOfWeekWidgetSpinner.getSelectedItem().getDataText(),
//                generateCadenceList()));
    }

    private ArrayList<Cadence> generateCadenceList() {
        // create ArrayList of all HolidaySlack
        // loop to create Arraylist of HolidaySlack and Cadence
        // can create shorter or longer cadence if needed
        return null;
    }

    @Override
    protected void onClickButtonOk() {
        createCadencesForFiscalYear(true);
        this.gcgActivity.stopDialog();
    }

}
