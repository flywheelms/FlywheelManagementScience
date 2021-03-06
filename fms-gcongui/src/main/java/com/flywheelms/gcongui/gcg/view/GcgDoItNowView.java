/* @(#)GcgDoItNowView.java
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

package com.flywheelms.gcongui.gcg.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.MotionEvent;
import android.view.View;

import com.flywheelms.gcongui.R;
import com.flywheelms.gcongui.gcg.interfaces.GcgDoItNowClient;

public class GcgDoItNowView extends GcgSurfaceView {
	
	private enum BitmapState {SAVE, DO_IT_NOW, EMPTY}
	
	private Bitmap saveDataBitmap;
	private Bitmap saveDataBitmapTouch;
	private Bitmap doItNowBitmap;
	private Bitmap doItNowBitmapTouch;
	private BitmapState bitmapState = BitmapState.EMPTY;

	public GcgDoItNowView(final Context aContext) {
		super(aContext);
		this.saveDataBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gcg__action__save__wide);
		this.saveDataBitmapTouch = BitmapFactory.decodeResource(getResources(), R.drawable.gcg__action__save__wide__touch);
		this.doItNowBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gcg__action__do_it_now__wide);
		this.doItNowBitmapTouch = BitmapFactory.decodeResource(getResources(), R.drawable.gcg__action__do_it_now__wide__touch);
		setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(GcgDoItNowView.this.bitmapState != BitmapState.EMPTY) {
					((GcgDoItNowClient) aContext).clickDoItNowMenuItem();
				}
			}
		});
		setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View aView, MotionEvent aMotionEvent) {
				if(aMotionEvent.getAction() == MotionEvent.ACTION_DOWN) {
					switch(GcgDoItNowView.this.bitmapState) {
						case EMPTY:
							break;
						case SAVE:
							drawBitmap(GcgDoItNowView.this.saveDataBitmapTouch);
							break;
						case DO_IT_NOW:
							drawBitmap(GcgDoItNowView.this.doItNowBitmapTouch);
							break;
						default:
					}
				}
//				} else {
//					switch(GcgDoItNowView.this.bitmapState) {
//						case EMPTY:
//							break;
//						case SAVE:
//							drawBitmap(GcgDoItNowView.this.saveDataBitmap);
//							break;
//						case DO_IT_NOW:
//							drawBitmap(GcgDoItNowView.this.doItNowBitmap);
//							break;
//						default:
//					}
//				}
				return false;
			}
		});
	}
	
	public void drawSaveDataBitmap() {
		this.bitmapState = BitmapState.SAVE;
        drawBitmap(this.saveDataBitmap);
	}
	
	public void drawDoItNowBitmap() {
		this.bitmapState = BitmapState.DO_IT_NOW;
        drawBitmap(this.doItNowBitmap);
	}
	
}
