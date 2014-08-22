/* @(#)FiscalYearDaoSqLite.java
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

import java.util.HashMap;

import android.content.ContentValues;
import android.database.Cursor;

import com.flywheelms.library.fmm.meta_data.FiscalYearMetaData;
import com.flywheelms.library.fmm.meta_data.IdNodeMetaData;
import com.flywheelms.library.fmm.node.impl.enumerator.FmmNodeDefinition;
import com.flywheelms.library.fmm.node.impl.governable.FiscalYear;

public class FiscalYearDaoSqLite extends CompletableNodeDaoSqLite<FiscalYear> {

	private static FiscalYearDaoSqLite singleton;

	public static FiscalYearDaoSqLite getInstance() {
		if(FiscalYearDaoSqLite.singleton == null) {
			FiscalYearDaoSqLite.singleton = new FiscalYearDaoSqLite();
		}
		return FiscalYearDaoSqLite.singleton;
	}
	
	@Override
	public FmmNodeDefinition getFmmNodeDefinition() {
		return FmmNodeDefinition.FISCAL_YEAR;
	}

	@Override
	protected void buildColumnIndexMap(Cursor aCursor) {
		super.buildColumnIndexMap(aCursor);
		putColumnIndexMapEntry(this.columnIndexMap, aCursor, FiscalYearMetaData.column_ORGANIZATION_ID);
		putColumnIndexMapEntry(this.columnIndexMap, aCursor, FiscalYearMetaData.column_YEAR_NUMBER);
	}

	@Override
	protected void getColumnValues(HashMap<String, Integer> aHashMap, Cursor aCursor, FiscalYear aFiscalYear) {
		super.getColumnValues(aHashMap, aCursor, aFiscalYear);
		aFiscalYear.setOrganizationNodeIdString(aCursor.getString(aHashMap.get(FiscalYearMetaData.column_ORGANIZATION_ID)));
		aFiscalYear.setYear(aCursor.getString(aHashMap.get(FiscalYearMetaData.column_YEAR_NUMBER)));
	}

	@Override
	public ContentValues buildContentValues(FiscalYear aFiscalYear) {
		ContentValues theContentValues = super.buildContentValues(aFiscalYear);
		theContentValues.put(FiscalYearMetaData.column_ORGANIZATION_ID, aFiscalYear.getOrganizationNodeIdString());
		theContentValues.put(FiscalYearMetaData.column_YEAR_NUMBER, aFiscalYear.getYearString());
		return theContentValues;
	}

	@Override
	public ContentValues buildUpdateContentValues(FiscalYear aFiscalYear) {
		return buildContentValues(aFiscalYear);
	}

	@Override
	protected FiscalYear getNextObjectFromCursor(Cursor aCursor) {
		FiscalYear theFiscalYear = null;
		theFiscalYear = new FiscalYear(
				aCursor.getString(this.columnIndexMap.get(IdNodeMetaData.column_ID)) );
		getColumnValues(this.columnIndexMap, aCursor, theFiscalYear);
		return theFiscalYear;
	}

}
