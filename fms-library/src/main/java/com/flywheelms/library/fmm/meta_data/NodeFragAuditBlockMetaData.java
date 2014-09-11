/* @(#)NodeFragAuditBlockMetaData.java
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

public class NodeFragAuditBlockMetaData extends NodeFragMetaData {

	public static final String key__NODE_FRAG__AUDIT_BLOCK = "NodeFragAuditBlock";
	
	public static final String column_PARENT_ABBREVIATED_NODE_ID = "parent_abbreviated_node_id";
	public static final String column_SEARCHABLE_HEADLINE = "headline";
	public static final String column_ITERATION = "iteration";
	public static final String column_CREATED_BY = "created_by";
	public static final String column_CREATED_TIMESTAMP = "created_timestamp";
	public static final String column_LAST_UPDATED_BY = "last_updated_by";
	public static final String column_SERIALIZED_NODE_HISTORY = "serialized_node_history";

	public static final String key__HISTORY_EVENT__LIST = "HistoryEventList";
	public static final String key__HISTORY_EVENT__SEQUENCE = "Sequence";
	public static final String key__HISTORY_EVENT__DATE = "Date";
	public static final String key__HISTORY_EVENT__COMMUNITY_MEMBER__NODE_ID = "CommunityMemberNodeId";
	public static final String key__HISTORY_EVENT__EVENT_TYPE = "EventType";
	public static final String key__HISTORY_EVENT__DATA__LIST = "DataList";
	
	public static void init() { return; }
	
}