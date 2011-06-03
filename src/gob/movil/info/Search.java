/*
 * Licencia GPL v3
 * "Gobierno Móvil" es un producto de "Gobierno en Línea".
 * Copyright (C) 2011 Richard Ricciardelli. Centro Nacional de Tecnologías de Información. All Rights Reserved.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see http://www.gnu.org/licenses
 */

//DEPRECATED

//package gob.movil.info;
//
//import gob.movil.R;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import android.app.Dialog;
//import android.app.ListActivity;
//import android.app.SearchManager;
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.TextView;
//
//public class Search extends ListActivity {
//	String TABLE1 = "alcaldias";
//	String TABLE2 = "tramites";
//	String TABLE3 = "funcionarios";
//	Show dialog = new Show();
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.search);
//
//		DatabaseHelper dbhelp = new DatabaseHelper(this);
//		final SQLiteDatabase db = dbhelp.getReadableDatabase();
//
//		Intent queryIntent = getIntent();
//		String queryAction = queryIntent.getAction();
//
//		if (Intent.ACTION_SEARCH.equals(queryAction)) {
//			String searchKeywords = queryIntent
//					.getStringExtra(SearchManager.QUERY);
//			Cursor a = db.rawQuery(
//					"SELECT * FROM " + TABLE1 + " WHERE "
//							+ replace("estado_alc", searchKeywords) + " OR "
//							+ replace("nombre_alc", searchKeywords) + " OR "
//							+ replace("cargo_alc", searchKeywords), null);
//
//			Cursor t = db.rawQuery(
//					"SELECT * FROM " + TABLE2 + " WHERE "
//							+ replace("nombre_tra", searchKeywords) + " OR "
//							+ replace("organismo_tra", searchKeywords), null);
//
//			Cursor f = db.rawQuery(
//					"SELECT * FROM " + TABLE3 + " WHERE ("
//							+ replace("ente_fun", searchKeywords) + " OR "
//							+ replace("nombre_fun", searchKeywords) + " OR "
//							+ replace("cargo_fun", searchKeywords)
//							+ ") AND poder_fun != 7", null);
//
//			if (!a.moveToFirst() && !t.moveToFirst() && !f.moveToFirst()) {
//				TextView tv = (TextView) findViewById(R.id.search_result);
//				tv.setText(getString(R.string.search_none, searchKeywords));
//				tv.setVisibility(0);
//			} else {
//				String[] array1 = showResults(a, 1), array2 = showResults(t, 2), array3 = showResults(
//						f, 3);
//				if (a.moveToFirst()) {
//					array1 = showResults(a, 1);
//				}
//				if (t.moveToFirst()) {
//					array2 = showResults(t, 2);
//				}
//				if (f.moveToFirst()) {
//					array3 = showResults(f, 3);
//				}
//				String[] list = mergeArrays(array1, array2, array3);
//				onResultSelected(list);
//			}
//		}
//	}
//
//	public String replace(String col, String key) {
//		String replacement = "REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(LOWER("
//				+ col
//				+ "),'á','a'), 'é','e'),'í','i'),'ó','o'),'ú','u'),'ñ','n') LIKE REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(LOWER('%"
//				+ key
//				+ "%'),'á','a'), 'é','e'),'í','i'),'ó','o'),'ú','u'),'ñ','n')";
//		return replacement;
//	}
//
//	public String[] mergeArrays(String[] first, String[] second, String[] third) {
//		List<String> all = new ArrayList<String>(first.length + second.length
//				+ third.length);
//		Collections.addAll(all, first);
//		Collections.addAll(all, second);
//		Collections.addAll(all, third);
//		return all.toArray(new String[] {});
//	}
//
//	public String[] showResults(Cursor c, int n) {
//		String[] items = new String[c.getCount()];
//		int i = 0;
//		if (c.moveToFirst()) {
//
//			do {
//				switch (n) {
//				case 1:
//					items[i] = c.getString(3) + "\n" + c.getString(4);
//					break;
//				case 2:
//					items[i] = c.getString(1) + "\n"
//							+ getString(R.string.tramites);
//					break;
//				case 3:
//					items[i] = c.getString(2) + "\n" + c.getString(3);
//					break;
//				}
//				i++;
//			} while (c.moveToNext());
//		}
//		return items;
//	}
//
//	public void onResultSelected(String[] listResults) {
//		DatabaseHelper dbhelp = new DatabaseHelper(this);
//		final SQLiteDatabase db = dbhelp.getReadableDatabase();
//
//		final ListView lv = (ListView) findViewById(R.id.list_result);
//		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, listResults);
//		lv.setAdapter(listAdapter);
//
//		lv.setOnItemClickListener(new OnItemClickListener() {
//			public void onItemClick(AdapterView<?> a, View v, int position,
//					long id) {
//				String querySelected = lv.getItemAtPosition(position)
//						.toString();
//
//				String[] querySplitted = querySelected.split("\n");
//
//				Cursor alc = db.rawQuery("SELECT * FROM " + TABLE1 + " WHERE "
//						+ replace("nombre_alc", querySplitted[0]) + " AND "
//						+ replace("cargo_alc", querySplitted[1]), null);
//				if (alc.moveToFirst()) {
//					if (lv.getItemAtPosition(position).equals(
//							alc.getString(3) + "\n" + alc.getString(4))) {
//						dialog.setDialog(Search.this, alc);
//					}
//				}
//
//				Cursor tra = db.rawQuery("SELECT * FROM " + TABLE2 + " WHERE "
//						+ replace("nombre_tra", querySplitted[0]), null);
//				if (tra.moveToFirst()) {
//					if (lv.getItemAtPosition(position).equals(
//							tra.getString(1) + "\n"
//									+ getString(R.string.tramites))) {
//						final Dialog dialog = new Dialog(Search.this);
//						dialog.setContentView(R.layout.show);
//						dialog.setTitle(tra.getString(1));
//
//						dialog.setCancelable(true);
//						dialog.setCanceledOnTouchOutside(true);
//						TextView text = (TextView) dialog
//								.findViewById(R.id.public_official);
//						text.setText(getString(R.string.organism) + ": "
//								+ tra.getString(2) + ".\n\n"
//								+ getString(R.string.requirements) + ":\n"
//								+ tra.getString(3) + ".\n\n"
//								+ getString(R.string.hours) + ": "
//								+ tra.getString(4) + ".\n\n"
//								+ getString(R.string.address) + ": "
//								+ tra.getString(5) + ".\n\n"
//								+ getString(R.string.cost) + ": "
//								+ tra.getString(6) + ".\n\n"
//								+ getString(R.string.info) + ": "
//								+ tra.getString(7) + ".\n");
//
//						Button button = (Button) dialog.findViewById(R.id.ok);
//
//						button.setOnClickListener(new OnClickListener() {
//							public void onClick(View v) {
//								dialog.dismiss();
//							}
//						});
//
//						dialog.show();
//					}
//				}
//				Cursor fun = db.rawQuery("SELECT * FROM " + TABLE3 + " WHERE "
//						+ replace("ente_fun", querySplitted[0]) + " AND "
//						+ replace("nombre_fun", querySplitted[1]), null);
//				if (fun.moveToFirst()) {
//					if (lv.getItemAtPosition(position).equals(
//							fun.getString(2) + "\n" + fun.getString(3))) {
//						dialog.setDialog(Search.this, fun);
//					}
//				}
//			}
//		});
//	}
//}