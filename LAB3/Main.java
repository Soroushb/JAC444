package main;

import shapes.Circle;
import shapes.Parallelogram;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;
import shapes.Triangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Main {

	public static void main(String[] args) {

		String fileName = "shapes.txt";
		int counter = 0;
		Shape  shapes[] = new Shape[50];
		String s;


		System.out.printf("------->JAC 444 Assignment 1<-------\n");

		System.out.printf("------->Task 1 ... <-------\n");

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((s = br.readLine()) != null) {
				String[] tokens = s.split(",");

				if (Objects.equals(tokens[0], "Circle") && tokens.length==2) {
					try {
						shapes[counter] = new Circle(Double.parseDouble(tokens[1]));
						counter++;

					}catch (Exception error) {
						System.out.println(error.getMessage());
					}
				}

				else if (Objects.equals(tokens[0], "Parallelogram") && tokens.length==3) {
					try {
						shapes[counter] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
						counter++;

					}catch (Exception error) {
						System.out.println(error.getMessage());
					}
				}

				else if (Objects.equals(tokens[0], "Square") && tokens.length==2) {
					try {
						shapes[counter] = new Square(Double.parseDouble(tokens[1]));
						counter++;

					}catch (Exception error) {
						System.out.println(error.getMessage());
					}
				}

				else if (Objects.equals(tokens[0], "Rectangle") && tokens.length==3) {
					try {
						shapes[counter] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
						counter++;

					}catch (Exception error) {
						System.out.println(error.getMessage());
					}
				}

				else if (Objects.equals(tokens[0], "Triangle") && tokens.length==4) {
					try {
						shapes[counter] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
						counter++;
					}catch (Exception error) {
						System.out.println(error.getMessage());
					}
				}
			}
		} catch (IOException error) {
			System.out.println(error.getMessage());
		}

		//Task 1 output
		System.out.println("\n" + counter + " shapes are created:");
		for(int i=0; i< counter; i++) {
			System.out.println(shapes[i] + "\n");
		}



		//******************************task 2******************************************** 

		double minTriangle = 0;
		double maxCircle = 0;
		int countSize = 0;
		int index = 0;

		//find a triangle (last triangle), It's not important which one, since we are going to find the 
		//smallest one, its perimeter must be smaller than every single triangle 
		for(int i = 0; i < counter; i++) {
			if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
				minTriangle = shapes[i].perimeter();
			}
		}

		//finding the triangles with smallest perimeters
		for(int i = 0; i < counter; i++) {
			if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
				if(shapes[i].perimeter() < minTriangle) {
					minTriangle = shapes[i].perimeter();
				}
			}
		}

		//finding the number of smallest triangles
		for(int i = 0; i < counter; i++) {
			if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
				if(shapes[i].perimeter() == minTriangle) {
					countSize++;
				}
			}
		}

		//finding the biggest circle
		for(int i = 0; i < counter; i++) {
			if(shapes[i].getClass().getSimpleName().equals("Circle")) {
				if(shapes[i].perimeter() > maxCircle) {
					maxCircle = shapes[i].perimeter();
				}
			}
		}

		//finding the number of biggest circles + biggest triangles
		for(int i = 0; i < counter; i++) {
			if(shapes[i].getClass().getSimpleName().equals("Circle")) {
				if(shapes[i].perimeter() == maxCircle) {
					countSize++;

				}
			}
		}


		int indexes[] = new int[countSize];

		//finding the indexes of smallest triangles and adding it to the indexes array
		for(int i = 0; i < counter; i++) {
			if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
				if(shapes[i].perimeter() == minTriangle) {
					indexes[index] = i;
					index++;
				}
			}
		}

		//finding the indexes of biggest circles and adding it to the indexes array
		for(int i = 0; i < counter; i++) {
			if(shapes[i].getClass().getSimpleName().equals("Circle")) {
				if(shapes[i].perimeter() == maxCircle) {
					indexes[index] = i;
					index++;
				}
			}
		}


		int newSize = counter - countSize; 
		Shape newArr[] = new Shape[newSize];




		//using the function to determine which indexes not to copy
		int j = 0;
		for(int i = 0; i < counter; i++) {

			if(isEqual(i, indexes) != true) {
				newArr[j] = shapes[i];
				j++;
			}
		}

		//task 2 output
		System.out.println("------->Task 2 ... <-------");
		for(int i = 0; i < newArr.length; i++) {
			System.out.println(newArr[i] + "\n");
		}


		//********************************task 3*****************************

		double parallelogramTotal = 0;
		double triangleTotal = 0;
		for(int i = 0; i < newArr.length; i++) {
			if(newArr[i].getClass().getSimpleName().equals("Parallelogram")){
				parallelogramTotal += newArr[i].perimeter();
			}
		}
		
		for(int i = 0; i < newArr.length; i++) {
			if(newArr[i].getClass().getSimpleName().equals("Triangle")){
				triangleTotal += newArr[i].perimeter();
			}
		}
		
		//task 3 output
		System.out.println("------->Task 3 ... <-------");
		System.out.println("Total perimeter of Parallelogram is: " + parallelogramTotal);
		System.out.println("Total perimeter of Triangle is: " + triangleTotal);

	}


	public static boolean isEqual(int index, int[] array) {
		boolean equal = false;
		for(int i = 0; i < array.length; i++) {
			if(index == array[i]) {
				equal = true;
			}
		}
		return equal;
	}}
