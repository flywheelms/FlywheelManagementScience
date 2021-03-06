/* @(#)FmsTreeNodeStateBundle.java
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

package com.flywheelms.library.fms.treeview;

import com.flywheelms.gcongui.gcg.treeview.node.GcgTreeNodeStateBundle;
import com.flywheelms.library.fms.activity.FmsActivity;

public class FmsTreeNodeStateBundle extends GcgTreeNodeStateBundle {

    public static final GcgTreeNodeStateBundle FWB__CONTEXT__NOTEBOOK = new FmsTreeNodeStateBundle("com.flywheelms.workbench.context.notebook");
    public static final GcgTreeNodeStateBundle FWB__CONTEXT__SERVICE_DELIVERY = new FmsTreeNodeStateBundle("com.flywheelms.workbench.context.service_delivery");
    public static final GcgTreeNodeStateBundle FWB__CONTEXT__STRATEGIC_PLANNING = new FmsTreeNodeStateBundle("com.flywheelms.workbench.context.strategic_planning");
    public static final GcgTreeNodeStateBundle FWB__CONTEXT__WORK_BREAKDOWN = new FmsTreeNodeStateBundle("com.flywheelms.workbench.context.work_breakdown");
    public static final GcgTreeNodeStateBundle FWB__CONTEXT__WORK_PLANNING = new FmsTreeNodeStateBundle("com.flywheelms.workbench.context.work_planning");
    public static final GcgTreeNodeStateBundle FWB__TEAMS_STRATEGY = new FmsTreeNodeStateBundle("com.flywheelms.workbench.teams.strategy");
    public static final GcgTreeNodeStateBundle FWB__TEAMS_FLYWHEEL = new FmsTreeNodeStateBundle("com.flywheelms.workbench.teams.flywheel");
    public static final GcgTreeNodeStateBundle FWB__TEAMS_FUNCTIONAL = new FmsTreeNodeStateBundle("com.flywheelms.workbench.teams.functional");
    public static final GcgTreeNodeStateBundle FWB__TEAMS_GOVERNANCE = new FmsTreeNodeStateBundle("com.flywheelms.workbench.teams.governance");

    static {
        GcgTreeNodeStateBundle.VALUES.add(FWB__CONTEXT__NOTEBOOK);
        GcgTreeNodeStateBundle.VALUES.add(FWB__CONTEXT__SERVICE_DELIVERY);
        GcgTreeNodeStateBundle.VALUES.add(FWB__CONTEXT__STRATEGIC_PLANNING);
        GcgTreeNodeStateBundle.VALUES.add(FWB__CONTEXT__WORK_BREAKDOWN);
        GcgTreeNodeStateBundle.VALUES.add(FWB__CONTEXT__WORK_PLANNING);
    }

    public static void init() { }

    private FmsTreeNodeStateBundle(String aKey) {
        super(aKey);
    }

    public String getKey() {
        return this.key + FmsActivity.getActiveDatabaseMediator().getActiveFmmConfiguration().getFileName();
    }
}