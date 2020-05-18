/* @(#)NodeFragAuditBlockDaoSqLite.java
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

package com.flywheelms.library.fmm.database.sqlite.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.flywheelms.gcongui.gcg.widget.date.GcgDateHelper;
import com.flywheelms.library.fmm.meta_data.IdNodeMetaData;
import com.flywheelms.library.fmm.meta_data.NodeFragAuditBlockMetaData;
import com.flywheelms.library.fmm.meta_data.NodeFragMetaData;
import com.flywheelms.library.fmm.node.impl.enumerator.FmmNodeDefinition;
import com.flywheelms.library.fmm.node.impl.nodefrag.NodeFragAuditBlock;

import java.util.HashMap;

public class NodeFragAuditBlockDaoSqLite extends NodeFragDaoSqLite<NodeFragAuditBlock> {

	private static NodeFragAuditBlockDaoSqLite singleton;

	public static NodeFragAuditBlockDaoSqLite getInstance() {
		if(NodeFragAuditBlockDaoSqLite.singleton == null) {
			NodeFragAuditBlockDaoSqLite.singleton = new NodeFragAuditBlockDaoSqLite();
		}
		return NodeFragAuditBlockDaoSqLite.singleton;
	}
	
	@Override
	public FmmNodeDefinition getFmmNodeDefinition() {
		return FmmNodeDefinition.NODE_FRAG__AUDIT_BLOCK;
	}

	@Override
	protected void buildColumnIndexMap(Cursor aCursor) {
		super.buildColumnIndexMap(aCursor);
		putColumnIndexMapEntry(this.columnIndexMap, aCursor, NodeFragAuditBlockMetaData.column_PARENT_ABBREVIATED_NODE_ID);
		putColumnIndexMapEntry(this.columnIndexMap, aCursor, NodeFragAuditBlockMetaData.column_SEARCHABLE_HEADLINE);
		putColumnIndexMapEntry(this.columnIndexMap, aCursor, NodeFragAuditBlockMetaData.column_ITERATION);
		putColumnIndexMapEntry(this.columnIndexMap, aCursor, NodeFragAuditBlockMetaData.column_CREATED_BY);
		putColumnIndexMapEntry(this.columnIndexMap, aCursor, NodeFragAuditBlockMetaData.column_CREATED_TIMESTAMP);
		putColumnIndexMapEntry(this.columnIndexMap, aCursor, NodeFragAuditBlockMetaData.column_LAST_UPDATED_BY);
		putColumnIndexMapEntry(this.columnIndexMap, aCursor, NodeFragAuditBlockMetaData.column_SERIALIZED_NODE_HISTORY);
	}

	@Override
	protected void getColumnValues(HashMap<String, Integer> aHashMap, Cursor aCursor, NodeFragAuditBlock aNodeFragAuditBlock) {
		super.getColumnValues(aHashMap, aCursor, aNodeFragAuditBlock);
		aNodeFragAuditBlock.setParentAbbreviatedNodeIdString(aCursor.getString(aHashMap.get(NodeFragAuditBlockMetaData.column_PARENT_ABBREVIATED_NODE_ID)));
		aNodeFragAuditBlock.setSearchableHeadline(aCursor.getString(aHashMap.get(NodeFragAuditBlockMetaData.column_SEARCHABLE_HEADLINE)));
		aNodeFragAuditBlock.setIteration(aCursor.getInt(aHashMap.get(NodeFragAuditBlockMetaData.column_ITERATION)));
		aNodeFragAuditBlock.setCreatedBy(aCursor.getString(aHashMap.get(NodeFragAuditBlockMetaData.column_CREATED_BY)));
		aNodeFragAuditBlock.setCreatedTimestamp(GcgDateHelper.getDateFromIso8601DateString(aCursor.getString(aHashMap.get(NodeFragAuditBlockMetaData.column_CREATED_TIMESTAMP))));
		aNodeFragAuditBlock.setLastUpdatedBy(aCursor.getString(aHashMap.get(NodeFragAuditBlockMetaData.column_LAST_UPDATED_BY)));
		aNodeFragAuditBlock.setSerializedNodeHistory(aCursor.getString(aHashMap.get(NodeFragAuditBlockMetaData.column_SERIALIZED_NODE_HISTORY)));
	}

	@Override
	protected NodeFragAuditBlock getNextObjectFromCursor(Cursor aCursor) {
		NodeFragAuditBlock theNodeFragAuditBlock = new NodeFragAuditBlock(
				aCursor.getString(this.columnIndexMap.get(IdNodeMetaData.column_ID)),
				aCursor.getString(this.columnIndexMap.get(NodeFragAuditBlockMetaData.column_SEARCHABLE_HEADLINE)),
				aCursor.getString(this.columnIndexMap.get(NodeFragMetaData.column_PARENT_ID)) );
		getColumnValues(this.columnIndexMap, aCursor, theNodeFragAuditBlock);
		return theNodeFragAuditBlock;
	}

	@Override
	public ContentValues buildContentValues(NodeFragAuditBlock aNodeFragAuditBlock) {
		ContentValues theContentValues = super.buildContentValues(aNodeFragAuditBlock);
		theContentValues.put(NodeFragAuditBlockMetaData.column_PARENT_ABBREVIATED_NODE_ID, aNodeFragAuditBlock.getParentAbbreviatedNodeIdString());
		theContentValues.put(NodeFragAuditBlockMetaData.column_SEARCHABLE_HEADLINE, aNodeFragAuditBlock.getSearchableHeadline());
		theContentValues.put(NodeFragAuditBlockMetaData.column_ITERATION, aNodeFragAuditBlock.getIteration());
		theContentValues.put(NodeFragAuditBlockMetaData.column_CREATED_BY, aNodeFragAuditBlock.getCreatedByNodeIdString());
		theContentValues.put(NodeFragAuditBlockMetaData.column_CREATED_TIMESTAMP, GcgDateHelper.getIso8601DateString(aNodeFragAuditBlock.getCreatedTimestamp()));
		theContentValues.put(NodeFragAuditBlockMetaData.column_LAST_UPDATED_BY, aNodeFragAuditBlock.getLastUpdatedByNodeIdString());
		theContentValues.put(NodeFragAuditBlockMetaData.column_SERIALIZED_NODE_HISTORY, aNodeFragAuditBlock.getSerializedNodeHistory());
		return theContentValues;
	}

	@Override
	public ContentValues buildUpdateContentValues(NodeFragAuditBlock aNodeFragAuditBlock) {
		ContentValues theContentValues = super.buildUpdateContentValues(aNodeFragAuditBlock);
		theContentValues.put(NodeFragAuditBlockMetaData.column_LAST_UPDATED_BY, aNodeFragAuditBlock.getLastUpdatedByNodeIdString());
		theContentValues.put(NodeFragAuditBlockMetaData.column_SERIALIZED_NODE_HISTORY, aNodeFragAuditBlock.getSerializedNodeHistory());
		return theContentValues;
	}

}
