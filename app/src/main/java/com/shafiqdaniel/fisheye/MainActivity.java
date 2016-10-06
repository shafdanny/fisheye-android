package com.shafiqdaniel.fisheye;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void generatePolygons() {
        ArrayList<MyPolygon> elements = new ArrayList<MyPolygon>();
        int originalSize[] = {1000,1000};
        int nb = 10;
        int marges = 10;

        // dimension dans laquelle s'inscrit un polygone
        float w = (originalSize[0] - marges*2) / (nb*2);
        float h = (originalSize[1] - marges*2) / (nb*2);
        // pour faire quelques carres différents
        int tiers = nb /3 ;
        int sixieme = nb /6 ;
        int deuxtiers = 2*nb /3 ;
        int troisquarts = 3*nb /4 ;
        float pasW = w/4;
        float pasH = h/4;
        // création de tous les polygones
        for(int i = 0; i < nb; i++)
        {
            for(int j = 0; j < nb; j++)
            {
                MyPolygon p = new MyPolygon();
                float dx = w*2*i+marges;
                float dy = h*2*j+marges;
                // ajout des points constituants les polygones
                if ((i == tiers) && (j==sixieme)) {
                    p.addPoint(dx, dy+pasH);
                    p.addPoint(dx+pasW, dy);
                }
                else {
                    p.addPoint(dx, dy);
                }
                p.addPoint(dx+w/2, dy);
                p.addPoint(dx+w, dy);
                p.addPoint(dx+w, dy+h/2);
                if ((i == troisquarts) && (j==deuxtiers)) {
                    p.addPoint(dx+w, dy - pasH+h);
                    p.addPoint(dx - pasW+w, dy+h);
                }
                else {
                    p.addPoint(dx + w, dy + h);
                }
                p.addPoint(dx+w/2, dy+h
                );
                p.addPoint(dx, dy+h);
                p.addPoint(dx
                        , dy+h/2);
                p.color = Color.BLACK;
                // ou une autre couleur qui dépend de i et de j
                elements.add(p);
            }
        }
    }
}
