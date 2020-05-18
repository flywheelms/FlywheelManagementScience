/*
 * Copyright (C) 2012 by Steven D. Stamps
 *
 *              Trademarks & Copyrights
 *  Flywheel Management Science(TM), Flywheel Management Model(TM),
 *  Flywheel Story Editor(TM) and FlywheelMS(TM) are exclusive trademarks
 *  of Steven D. Stamps and may only be used freely for the purpose of
 *  identifying the unforked version of this software.  Subsequent forks
 *  may not use these trademarks.  All other rights are reserved.
 *
 *  DecKanGL (Decorated Kanban Glyph Language) and TribKn (Tribal Knowledge)
 *  are also exclusive trademarks of Steven D. Stamps.  These may be used
 *  freely within the unforked FlywheelMS application and documentation.
 *  All other rights are reserved.
 *
 *  gConGUI (game Controller Graphical User Interface) is an exclusive
 *  trademark of Steven D. Stamps.  This trademark may be used freely
 *  within the unforked FlywheelMS application and documentation.
 *  All other rights are reserved.
 *
 * * Trademark information is available at
 * * <http://www.flywheelms.com/trademarks>
 * *
 * * Flywheel Management Science(TM) is a copyrighted body of management
 * * metaphors, governance processes, and leadership techniques that is
 * * owned by Steven D. Stamps.  These copyrighted materials may be freely
 * * used, without alteration, by the community (users and developers)
 * * surrounding this GPL3-licensed software.  Additional copyright
 * * information is available at <http://www.flywheelms.org/copyrights>
 * *
 * *              GPL3 Software License
 * * This program is free software: you can use it, redistribute it and/or
 * * modify it under the terms of the GNU General Public License, version 3,
 * * as published by the Free Software Foundation. This program is distributed
 * * in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * * PURPOSE.  See the GNU General Public License for more details. You should
 * * have received a copy of the GNU General Public License, in a file named
 * * COPYING, along with this program.  If you cannot find your copy, see
 * * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */

package com.flywheelms.fms_library.fmm.database.sqlite.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.flywheelms.fms_library.fmm.meta_data.CompletableNodeMetaData;
import com.flywheelms.fms_library.fmm.meta_data.IdNodeMetaData;
import com.flywheelms.fms_library.fmm.meta_data.WorkPlanMetaData;
import com.flywheelms.fms_library.fmm.node.impl.enumerator.FmmNodeDefinition;
import com.flywheelms.fms_library.fmm.node.impl.governable.WorkPlan;

import java.util.HashMap;

public class WorkPlanDaoSqLite extends CompletableNodeDaoSqLite<WorkPlan> {

    private static WorkPlanDaoSqLite singleton;

    public static WorkPlanDaoSqLite getInstance() {
        if(WorkPlanDaoSqLite.singleton == null) {
            WorkPlanDaoSqLite.singleton = new WorkPlanDaoSqLite();
        }
        return WorkPlanDaoSqLite.singleton;
    }

    @Override
    public FmmNodeDefinition getFmmNodeDefinition() {
        return FmmNodeDefinition.WORK_PLAN;
    }

    @Override
    protected void buildColumnIndexMap(Cursor aCursor) {
        super.buildColumnIndexMap(aCursor);
        putColumnIndexMapEntry(this.columnIndexMap, aCursor, WorkPlanMetaData.column_CADENCE_ID);
        putColumnIndexMapEntry(this.columnIndexMap, aCursor, CompletableNodeMetaData.column_SEQUENCE);
        putColumnIndexMapEntry(this.columnIndexMap, aCursor, WorkPlanMetaData.column_SCHEDULED_START_DATE);
        putColumnIndexMapEntry(this.columnIndexMap, aCursor, WorkPlanMetaData.column_SCHEDULED_END_DATE);
        putColumnIndexMapEntry(this.columnIndexMap, aCursor, WorkPlanMetaData.column_HOLIDAY);
    }

    @Override
    protected void getColumnValues(HashMap<String, Integer> aHashMap, Cursor aCursor, WorkPlan aWorkPlan) {
        super.getColumnValues(aHashMap, aCursor, aWorkPlan);
        aWorkPlan.setCadenceId(aCursor.getString(aHashMap.get(WorkPlanMetaData.column_CADENCE_ID)));
        aWorkPlan.setScheduledStartDate(aCursor.getLong(aHashMap.get(WorkPlanMetaData.column_SCHEDULED_START_DATE)));
        aWorkPlan.setScheduledEndDate(aCursor.getLong(aHashMap.get(WorkPlanMetaData.column_SCHEDULED_END_DATE)));
        aWorkPlan.setFmmHoliday(aCursor.getString(aHashMap.get(WorkPlanMetaData.column_HOLIDAY)));
    }

    @Override
    public ContentValues buildContentValues(WorkPlan aWorkPlan) {
        ContentValues theContentValues = super.buildContentValues(aWorkPlan);
        theContentValues.put(WorkPlanMetaData.column_CADENCE_ID, aWorkPlan.getCadenceId());
        theContentValues.put(WorkPlanMetaData.column_SCHEDULED_START_DATE, aWorkPlan.getScheduledStartDateFormattedUtcLong());
        theContentValues.put(WorkPlanMetaData.column_SCHEDULED_END_DATE, aWorkPlan.getScheduledEndDateFormattedUtcLong());
        theContentValues.put(WorkPlanMetaData.column_HOLIDAY, aWorkPlan.getFmmHolidayName());
        return theContentValues;
    }

    @Override
    public ContentValues buildUpdateContentValues(WorkPlan aWorkPlan) {
        return buildContentValues(aWorkPlan);
    }

    @Override
    protected WorkPlan getNextObjectFromCursor(Cursor aCursor) {
        WorkPlan theWorkPlan = new WorkPlan(
                aCursor.getString(this.columnIndexMap.get(IdNodeMetaData.column_ID)) );
        getColumnValues(this.columnIndexMap, aCursor, theWorkPlan);
        return theWorkPlan;
    }

}