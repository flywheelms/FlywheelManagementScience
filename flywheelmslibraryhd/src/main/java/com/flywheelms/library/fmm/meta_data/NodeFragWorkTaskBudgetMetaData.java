/* @(#)NodeFragWorkTaskBudgetMetaData.java
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

package com.flywheelms.library.fmm.meta_data;

public class NodeFragWorkTaskBudgetMetaData extends NodeFragMetaData {

	public static final String key__NODE_FRAG_WORK_TASK_BUDGET = "NodeFragWorkTaskBudget";
	
	public static final String column_ESTIMATED_TOTAL_TASK_COUNT = "estimated_total_task_count";
	public static final String column_ESTIMATED_AVERAGE_HOURS_PER_TASK = "estimated_average_hours_per_task";
	public static final String column_SWAG_BY = "swag_by";
	public static final String column_SWAG_TIMESTAMP = "swag_timestamp";
	public static final String column_ESTIMATE_CONFIRMED_BY = "estimate_confirmed_by";
	public static final String column_ESTIMATE_CONFIRMED_TIMESTAMP = "estimate_confirmed_timestamp";
	public static final String column_BUDGETED_TOTAL_TASK_COUNT = "budgeted_total_task_count";
	public static final String column_BUDGETED_AVERAGE_HOURS_PER_TASK = "budgeted_average_hours_per_task";
	public static final String column_BUDGET_PROPOSED_BY = "budget_proposed_by";
	public static final String column_BUDGET_PROPOSED_TIMESTAMP = "budget_proposed_timestamp";
	public static final String column_BUDGET_CONFIRMED_BY = "budget_confirmed_by";
	public static final String column_BUDGET_CONFIRMED_TIMESTAMP = "budget_confirmed_timestamp";
	public static final String column_WORK_BREAKDOWN_TOTAL_TASK_COUNT = "work_breakdown_total_task_count";
	public static final String column_WORK_BREAKDOWN_AVERAGE_HOURS_PER_TASK = "work_breakdown_average_hours_per_task";
	public static final String column_TASK_COUNT_AFTER_COMPLETION = "task_count_after_completion";
	public static final String column_AVERAGE_HOURS_PER_TASK_AFTER_COMPLETION = "average_hours_per_task_after_completion";
	
	public static void init() { return; }

}
