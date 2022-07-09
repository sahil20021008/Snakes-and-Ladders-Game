package application;

import java.util.*;
import javafx.geometry.Point2D;


public class Snakes_Ladders {
	protected HashMap<Integer, Integer>snakes;
	protected HashMap<Integer, Integer>ladders;
	protected HashMap<Integer, Point2D>coordinates;
	protected HashMap<Integer, ArrayList<Point2D>>snakers;
	protected HashMap<Integer, ArrayList<Point2D>>ladderers;
	protected double[]row;
	protected double[]col;
	public Snakes_Ladders() {
		snakes=new HashMap<>();
		ladders=new HashMap<>();
		coordinates=new HashMap<>();
		row=new double[10];
		col=new double[10];
		snakers=new HashMap<>();
		ladderers=new HashMap<>();
		snakes.put(16,6);
		snakes.put(46, 25);
		snakes.put(49, 11);
		snakes.put(62, 19);
		snakes.put(64, 60);
		snakes.put(74, 53);
		snakes.put(92, 88);
		snakes.put(95, 75);
		snakes.put(99, 80);
		
		ladders.put(2, 38);
		ladders.put(7,14);
		ladders.put(8, 31);
		ladders.put(15, 26);
		ladders.put(21, 42);
		ladders.put(28, 84);
		ladders.put(36, 44);
		ladders.put(51, 67);
		ladders.put(71, 91);
		ladders.put(78, 98);
		ladders.put(87, 94);
		
		col[0]=375.3333333333333;
		row[0]=34.6666666666666;
		row[1]=74;
		col[1]=338;
		for(int i=2;i<10;i++) {
			row[i]=row[i-1]+row[1]-row[0];
			col[i]=col[i-1]+col[1]-col[0];
		}
		int k=1;
		for(int i=0;i<5;i++) {
			for(int j=0;j<10;j++) {
				coordinates.put(k++, new Point2D(row[j], col[2*i]));
			}
			k+=10;
		}
		k=11;
		for(int i=0;i<5;i++) {
			for(int j=0;j<10;j++) {
				coordinates.put(k++, new Point2D(row[9-j], col[2*i+1]));
			}
			k+=10;
		}
		
		ArrayList<Point2D>s1=new ArrayList<>();
		ArrayList<Point2D>s2=new ArrayList<>();
		ArrayList<Point2D>s3=new ArrayList<>();
		ArrayList<Point2D>s4=new ArrayList<>();
		ArrayList<Point2D>s5=new ArrayList<>();
		ArrayList<Point2D>s6=new ArrayList<>();
		ArrayList<Point2D>s7=new ArrayList<>();
		ArrayList<Point2D>s8=new ArrayList<>();
		ArrayList<Point2D>s9=new ArrayList<>();
		
		ArrayList<Point2D>l1=new ArrayList<>();
		ArrayList<Point2D>l2=new ArrayList<>();
		ArrayList<Point2D>l3=new ArrayList<>();
		ArrayList<Point2D>l4=new ArrayList<>();
		ArrayList<Point2D>l5=new ArrayList<>();
		ArrayList<Point2D>l6=new ArrayList<>();
		ArrayList<Point2D>l7=new ArrayList<>();
		ArrayList<Point2D>l8=new ArrayList<>();
		ArrayList<Point2D>l9=new ArrayList<>();
		ArrayList<Point2D>l10=new ArrayList<>();
		ArrayList<Point2D>l11=new ArrayList<>();
		
		s1.add(coordinates.get(16));
		s1.add(new Point2D(150.6666666666, 361.3333333333));
		s1.add(new Point2D(186.6666666666, 378.0));
		s1.add(coordinates.get(6));
		snakers.put(16, s1);
		
		s2.add(coordinates.get(46));
		s2.add(new Point2D(227.33333333, 249.33333333));
		s2.add(new Point2D(218.66666666, 260));
		s2.add(new Point2D(155.33333333, 264.66666666));
		s2.add(new Point2D(156, 294));
		s2.add(coordinates.get(25));
		snakers.put(46, s2);
		
		s3.add(coordinates.get(49));
		s3.add(new Point2D(309.33333333, 226));
		s3.add(new Point2D(304.66666666, 239.33333333));
		s3.add(new Point2D(310.66666666, 250.66666666));
		s3.add(new Point2D(351.33333333, 269.33333333));
		s3.add(new Point2D(336.66666666, 326.66666666));
		s3.add(coordinates.get(11));
		snakers.put(49, s3);
		
		s4.add(coordinates.get(62));
		s4.add(new Point2D(87.33333333, 151.33333333));
		s4.add(new Point2D(80.66666666, 210.66666666));
		s4.add(new Point2D(112, 222));
		s4.add(new Point2D(118.66666666,230.66666666));
		s4.add(new Point2D(85.33333333, 260.66666666));
		s4.add(new Point2D(70, 290.66666666));
		s4.add(new Point2D(44.66666666, 298.66666666));
		s4.add(new Point2D(34, 320.66666666));
		s4.add(coordinates.get(19));
		snakers.put(62, s4);
		
		s5.add(coordinates.get(64));
		s5.add(new Point2D(125.33333333, 152.66666666));
		s5.add(new Point2D(81.33333333, 154.66666666));
		s5.add(new Point2D(59.33333333,184.66666666));
		s5.add(coordinates.get(60));
		snakers.put(64, s5);
		
		s6.add(coordinates.get(74));
		s6.add(new Point2D(234, 118));
		s6.add(new Point2D(236.66666666, 138.66666666));
		s6.add(new Point2D(258.66666666, 146));
		s6.add(new Point2D(264.66666666, 160.66666666));
		s6.add(new Point2D(260.66, 174));
		s6.add(new Point2D(250, 180));
		s6.add(new Point2D(240, 168));
		s6.add(new Point2D(250, 152.66666666));
		s6.add(new Point2D(271.33333333, 169.33333333));
		s6.add(coordinates.get(53));
		snakers.put(74, s6);
		
		s7.add(coordinates.get(92));
		s7.add(new Point2D(321.33333333, 31.33333333));
		s7.add(new Point2D(326.66666666, 41.33333333));
		s7.add(new Point2D(308.66666666, 40.66666666));
		s7.add(new Point2D(313.33333333, 55.33333333));
		s7.add(coordinates.get(88));
		snakers.put(92, s7);
		
		s8.add(coordinates.get(95));
		s8.add(new Point2D(198, 42));
		s8.add(new Point2D(195.33333333, 65.33333333));
		s8.add(new Point2D(223.33333333, 78));
		s8.add(new Point2D(227.33333333, 94.66666666));
		s8.add(coordinates.get(75));
		snakers.put(95, s8);
		
		s9.add(coordinates.get(99));
		s9.add(new Point2D(76, 48));
		s9.add(new Point2D(66.66666666, 61.66666666));
		s9.add(new Point2D(45.33333333, 61.33333333));
		s9.add(new Point2D(39.33333333, 74.66666666));
		s9.add(new Point2D(46, 94));
		s9.add(new Point2D(36.66666666, 107.33333333));
		s9.add(coordinates.get(80));
		snakers.put(99, s9);
		
		l1.add(coordinates.get(2));
		l1.add(new Point2D(80.66666666, 334));
		l1.add(new Point2D(97.33333333, 292));
		l1.add(coordinates.get(38));
		ladderers.put(2, l1);
		
		l2.add(coordinates.get(7));
		l2.add(coordinates.get(14));
		ladderers.put(7, l2);
		
		l3.add(coordinates.get(8));
		l3.add(new Point2D(322, 325.33333333));
		l3.add(new Point2D(345.33333333, 294));
		l3.add(coordinates.get(31));
		ladderers.put(8, l3);
		
		l4.add(coordinates.get(15));
		l4.add(coordinates.get(26));
		ladderers.put(15, l4);
		
		l5.add(coordinates.get(21));
		l5.add(new Point2D(48.66666666, 254));
		l5.add(coordinates.get(42));
		ladderers.put(21, l5);
		
		l6.add(coordinates.get(28));
		l6.add(new Point2D(272.66666666, 252.66666666));
		l6.add(new Point2D(249.33333333, 216.66666666));
		l6.add(new Point2D(222, 180));
		l6.add(new Point2D(196, 142.66666666));
		l6.add(new Point2D(168, 102));
		l6.add(coordinates.get(84));
		ladderers.put(28, l6);
		
		l7.add(coordinates.get(36));
		l7.add(coordinates.get(44));
		ladderers.put(36, l7);
		
		l8.add(coordinates.get(51));
		l8.add(coordinates.get(67));
		ladderers.put(51, l8);
		
		l9.add(coordinates.get(71));
		l9.add(new Point2D(377.33333333, 66));
		l9.add(coordinates.get(91));
		ladderers.put(71, l9);
		
		l10.add(coordinates.get(78));
		l10.add(new Point2D(110.66666666, 65.33333333));
		l10.add(coordinates.get(98));
		ladderers.put(78, l10);
		
		l11.add(coordinates.get(87));
		l11.add(coordinates.get(94));
		ladderers.put(87, l11);
	}
}
