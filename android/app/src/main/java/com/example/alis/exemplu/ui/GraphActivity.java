package com.example.alis.exemplu.ui;

import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.alis.exemplu.R;
import com.example.alis.exemplu.model.Recipe;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alis on 12/5/2017.
 */

public class GraphActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);


        final SharedPreferences prefs = getSharedPreferences("loginPref", MODE_PRIVATE);
        final int id=prefs.getInt("id",-1);

        List<Recipe> recipes=new ArrayList<>();
        HashMap<Integer,Integer>points=new HashMap<>();
        for(int i=0;i<6;i++){
            points.put(i,0);
        }
        for(int i=0;i<recipes.size();i++){
            Integer nrStars=Math.round(recipes.get(i).getNrStars());
            Integer currValue=points.get(nrStars);
            points.put(nrStars,++currValue);
            Log.i("POINTS",nrStars+" "+currValue);
        }
        GraphView graph = (GraphView) findViewById(R.id.graph);

        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, points.get(0)),
                new DataPoint(1, points.get(1)),
                new DataPoint(2, points.get(2)),
                new DataPoint(3, points.get(3)),
                new DataPoint(4, points.get(4)),
                new DataPoint(5, points.get(5))
        });
        graph.addSeries(series);

        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });
    }
}
