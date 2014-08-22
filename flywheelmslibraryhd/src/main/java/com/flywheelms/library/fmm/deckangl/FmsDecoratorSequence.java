/* @(#)FmsDecoratorSequence.java
** 
** Copyright (C) 2012 by Steven D. Stamps
**
**             Trademarks & Copyrights
** Flywheel Management Science(TM), Flywheel Management Model(TM),
** Flywheel Sequence Editor(TM) and FlywheelMS(TM) are exclusive trademarks
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

package com.flywheelms.library.fmm.deckangl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.graphics.drawable.Drawable;

import com.flywheelms.library.R;
import com.flywheelms.library.deckangl.enumerator.DecKanGlDecoratorCanvasLocation;
import com.flywheelms.library.deckangl.enumerator.DecKanGlDecoratorColor;
import com.flywheelms.library.deckangl.glyph.DecKanGlDecoratorEnumeration;
import com.flywheelms.library.fmm.node.impl.enumerator.TribKnQualityNormalizedDescription;
import com.flywheelms.library.gcg.GcgApplication;

public class FmsDecoratorSequence extends DecKanGlDecoratorEnumeration {
	
	protected static String qualityMetricName = GcgApplication.getAppResources().getString(R.string.tribkn_quality_metric__sequence);
	protected static String qualityMetricDescription = GcgApplication.getAppResources().getString(R.string.tribkn_quality_metric__sequence__description);
	protected static Drawable qualityMetricDrawable = GcgApplication.getAppResources().getDrawable(R.drawable.tribkn_quality_metric__sequence);
	protected static DecKanGlDecoratorCanvasLocation decoratorCanvasLocation = DecKanGlDecoratorCanvasLocation.bottom_zone_MIDDLE;
	
	@Override
	public String getQualityMetricName() {
		return FmsDecoratorSequence.qualityMetricName;
	}
	
	@Override
	public String getQualityMetricDescription() {
		return FmsDecoratorSequence.qualityMetricDescription;
	}
	
	@Override
	public Drawable getQualityMetricDrawable() {
		return FmsDecoratorSequence.qualityMetricDrawable;
	}
	
	@Override
	public DecKanGlDecoratorCanvasLocation getDecoratorCanvasLocation() {
		return FmsDecoratorSequence.decoratorCanvasLocation;
	}
	
	protected static FmsDecoratorSequence staticInstance = new FmsDecoratorSequence();
	
	public static FmsDecoratorSequence NO_SEQUENCE = new FmsDecoratorSequence(
			"No Sequence",
			R.string.decorator__sequence__none,
			TribKnQualityNormalizedDescription.NONE,
			R.integer.decorator__sequence__none__quality_index,
			DecKanGlDecoratorColor.RED );
	public static FmsDecoratorSequence SEQUENCE_SWAG = new FmsDecoratorSequence(
			"Sequence SWAG",
			R.string.decorator__sequence__swag,
			TribKnQualityNormalizedDescription.SWAG,
			R.integer.decorator__sequence__swag__quality_index,
			DecKanGlDecoratorColor.YELLOW );
	public static FmsDecoratorSequence SUGGESTED_SEQUENCE = new FmsDecoratorSequence(
			"Suggested Sequence",
			R.string.decorator__sequence__suggested,
			TribKnQualityNormalizedDescription.SUGGESTED,
			R.integer.decorator__sequence__suggested__quality_index,
			DecKanGlDecoratorColor.BLUE );
	public static FmsDecoratorSequence PROPOSED_SEQUENCE = new FmsDecoratorSequence(
			"Proposed Sequence",
			R.string.decorator__sequence__proposed,
			TribKnQualityNormalizedDescription.PROPOSED,
			R.integer.decorator__sequence__proposed__quality_index,
			DecKanGlDecoratorColor.PINK );
	public static FmsDecoratorSequence CONFIRMED_SEQUENCE = new FmsDecoratorSequence(
			"Confirmed Sequence",
			R.string.decorator__sequence__confirmed,
			TribKnQualityNormalizedDescription.CONFIRMED,
			R.integer.decorator__sequence__confirmed__quality_index,
			DecKanGlDecoratorColor.TRANSPARENT );
	public static FmsDecoratorSequence MODIFIED_SINCE_CONFIRMED_SEQUENCE = new FmsDecoratorSequence(
			"Sequence Modified Since Confirmed",
			R.string.decorator__sequence__modified_since_confirmed,
			TribKnQualityNormalizedDescription.MODIFIED_SINCE_CONFIRMED,
			R.integer.decorator__sequence__modified_since_confirmed__quality_index,
			DecKanGlDecoratorColor.ORANGE );
	public static FmsDecoratorSequence UNKNOWN_SEQUENCE_QUALITY = new FmsDecoratorSequence(
			"Unknown Sequence Quality",
			R.string.decorator__sequence__unknown_quality,
			TribKnQualityNormalizedDescription.UNKNOWN,
			R.integer.decorator__sequence__unknown_quality__quality_index,
			DecKanGlDecoratorColor.GRAY );
	public static FmsDecoratorSequence SEQUENCE_QUALITY_NOT_APPLICABLE = new FmsDecoratorSequence(
			"Sequence Quality Not Applicable",
			R.string.decorator__sequence__not_applicable,
			TribKnQualityNormalizedDescription.NOT_APPLICABLE,
			R.integer.decorator__sequence__not_applicable__quality_index,
			DecKanGlDecoratorColor.GRAY );
	public static FmsDecoratorSequence SEQUENCE_QUALITY_NOT_ENABLED = new FmsDecoratorSequence(
			"Sequence Quality Not Enabled",
			R.string.decorator__sequence__not_enabled,
			TribKnQualityNormalizedDescription.NOT_ENABLED,
			R.integer.decorator__sequence__not_enabled__quality_index,
			DecKanGlDecoratorColor.DISABLED );
	
	protected static ArrayList<DecKanGlDecoratorEnumeration> valuesList =
			new ArrayList<DecKanGlDecoratorEnumeration>();
	static {
		valuesList.add(NO_SEQUENCE);
		valuesList.add(SEQUENCE_SWAG);
		valuesList.add(SUGGESTED_SEQUENCE);
		valuesList.add(PROPOSED_SEQUENCE);
		valuesList.add(CONFIRMED_SEQUENCE);
		valuesList.add(MODIFIED_SINCE_CONFIRMED_SEQUENCE);
		valuesList.add(UNKNOWN_SEQUENCE_QUALITY);
		valuesList.add(SEQUENCE_QUALITY_NOT_APPLICABLE);
		valuesList.add(SEQUENCE_QUALITY_NOT_ENABLED);
	}
	
	protected static HashMap<String, FmsDecoratorSequence> nameMap = new HashMap<String, FmsDecoratorSequence>();
	static {
		for(DecKanGlDecoratorEnumeration theDecKanGlDecoratorEnumeration : valuesList) {
			FmsDecoratorSequence.nameMap.put(theDecKanGlDecoratorEnumeration.getName(), (FmsDecoratorSequence) theDecKanGlDecoratorEnumeration);
		}
	}
	
	public static FmsDecoratorSequence getObjectForName(String aName) {
		return FmsDecoratorSequence.nameMap.get(aName);
	}
	
	private FmsDecoratorSequence() {
		super();
	}
	
	public static FmsDecoratorSequence getStaticInstance() {
		return staticInstance;
	}
	
	public FmsDecoratorSequence(
			String aName,
			int aDescriptionResourceId,
			TribKnQualityNormalizedDescription aNormalizedDescription,
			int aTribKnQualityIndexResourceId,
			DecKanGlDecoratorColor aDecKanGlDecoratorColor ) {
		super(
				aName,
				GcgApplication.getAppResources().getString(aDescriptionResourceId),
				aNormalizedDescription,
				GcgApplication.getAppResources().getInteger(aTribKnQualityIndexResourceId),
				aDecKanGlDecoratorColor);
	}
	
	public static List<DecKanGlDecoratorEnumeration> values() {
		return valuesList;
	}

	@Override
	public String getLabelText() {
		return GcgApplication.getContext().getResources().getString(R.string.tribkn_quality_metric__sequence);
	}

	@Override
	public Drawable getLabelDrawable() {
		return GcgApplication.getContext().getResources().getDrawable(R.drawable.tribkn_quality_metric__sequence);
	}

	@Override
	public int getLabelDrawableResourceId() {
		return R.drawable.tribkn_quality_metric__sequence;
	}

}