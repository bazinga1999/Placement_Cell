import java.util.*; 
import java.lang.*; 
import java.math.BigInteger;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*; 

import javax.swing.*;


class student{
	final int roll_no;
	final String branch;
	final double cgpa;
	boolean placement_status = false;
	ArrayList<company> applied_for = new ArrayList<company>();
	ArrayList<Integer> technical_scores = new ArrayList<Integer>();
	int technical_score;
	String placed_at = "";
	
	
	student(int roll_no,String branch,double cgpa){
		this.roll_no = roll_no;
		this.branch = branch;
		this.cgpa = cgpa;
	}
	
	
	
}

class company{
	final String name;
	ArrayList<String> eligible_branches = new ArrayList<String>();
	int students_required;
	boolean application_status = true;
	ArrayList<student> selected_students = new ArrayList<student>();
	int branches_count;
	ArrayList<student> available_students = new ArrayList<student>();

	
	company(String name,ArrayList<String> eligible_branches,int students_required){
		this.name = name;
		this.eligible_branches = eligible_branches;
		this.students_required = students_required;
	}
	
	
}


public class May2 
{ 
	

	
	
    public static void main (String[] args) 
    { 
    	
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in); 
        

    	ArrayList<student> students = new ArrayList<student>();
    	ArrayList<company> companies = new ArrayList<company>();
    	
    	//adding students
    	
    	System.out.print("Number of students - ");
    	int students_count = in.nextInt();
    	for(int i = 0;i<students_count;i++){
    		double cgpa = in.nextDouble();
    		String branch = in.next();
    		if(branch.equals("CSE") || branch.equals("CSE") || branch.equals("ECE") || branch.equals("CSAM") || branch.equals("CSSS") || branch.equals("CSD") || branch.equals("CSB"))
    		{student temp = new student(i+1,branch,cgpa);
    		students.add(temp);
    	
    		}else{
    			System.out.println("Enter Valid Branch : {CSE,CSAM,CSD,CSSS,CSB}");
    			i--;
    		}
    	}    	
    	int students_placed = students_count;
    	while(students_placed != 0){
	    	
	    	System.out.print("Query - ");
	    	int query = in.nextInt();
	    	//query 1

	    	
	    	if(query == 1){
	    		
	    		//input
	    		System.out.print("Name - ");
	    		String name = in.next();
	    		System.out.print("Number of Eligible Courses = ");
	    		int branches_count = in.nextInt();
	    		ArrayList<String> branches = new ArrayList<String>();
	    		for(int i = 0;i<branches_count;i++){
	    			String branch = in.next();
	        		if(branch.equals("CSE") || branch.equals("CSE") || branch.equals("ECE") || branch.equals("CSAM") || branch.equals("CSSS") || branch.equals("CSD") || branch.equals("CSB"))
	        		{
	        			branches.add(branch);
	        		}else{
	        			System.out.println("Enter Valid Branch : {CSE,CSAM,CSD,CSSS,CSB,ECE}");
	        			i--;
	        		}
	    		}
	    		System.out.print("Number of Required Students = ");
	    		int students_required = in.nextInt();
	    		
	    		company temp = new company(name,branches,students_required);
	    		temp.branches_count = branches_count;
	    		
	    		//output
	    		System.out.println("Name - " + temp.name);
	    		System.out.println("course criteria");
	    		for(int i = 0;i<temp.branches_count;i++){
	    			System.out.println(temp.eligible_branches.get(i));
	    		}
	    		System.out.println("Number of Required Students = " + temp.students_required);
	    		
	    		ArrayList<student> students_available = new ArrayList<student>();
	    		
	    		//adding available students for the company
	    		for(int i = 0;i<temp.branches_count;i++){
	    			for(int j = 0;j<students.size() ;j++){
	    				if(students.get(j).branch.equals(temp.eligible_branches.get(i)) && !students.get(j).placement_status ){
	    					students_available.add(students.get(j));
	    				}
	    			}
	    		}
	    		
	    		if(students_available.size()==0){
	    			System.out.println("Application Status = Open");
	    		}
	    		else{
	    			System.out.println("Application Status = Open");
	    			System.out.println("Enter scores for the technical round");
	    			for(int j = 0;j<students_available.size();j++){
	    				System.out.println("Enter technical score of Roll no. " + students_available.get(j).roll_no);
	    				students_available.get(j).technical_score = in.nextInt();
	    				
	    				int index = -1;
	    				for(int i = 0;i<students.size();i++){
	    					if(students.get(i).roll_no == students_available.get(j).roll_no){
	    						index = i;
	    						break;
	    					}
	    				}
	    				students.get(index).technical_scores.add(students_available.get(j).technical_score);
	    				students.get(index).applied_for.add(temp);
	    			}
	    		}
	    				//sorting with technical scores and cgpa
	    		    	Collections.sort(students_available,new Comparator<student>()
	    		    	{
	    		    		public int compare(student s1,student s2){
	    		    			if(s2.technical_score != s1.technical_score){
	    		    				return Integer.valueOf(s2.technical_score).compareTo(s1.technical_score);
	    		    			}else{
	    		    				return Double.valueOf(s2.cgpa).compareTo(s1.cgpa);
	    		    			}
	    		    		}
	    		    	});
	    		
	    		
	    		
	    		temp.available_students = students_available;
	    		
	    		companies.add(temp);
	    	}
	    	
	    	//query 2
	    	if(query == 2){
		    	System.out.println("Accounts removed for ");
		    	int count = 0;
		    	for(int i = 0;i<students.size();i++){
		    		if(students.get(i).placement_status){
		    			System.out.println(students.get(i).roll_no);
		    			students.remove(i);
		    			count++;
		    		}
		    	}
		    	if(count == 0){
		    		System.out.println("No Student");
		    	}
	    	}
	    	
	    	//query 3
	    	if(query == 3){
		    	System.out.println("Accounts removed for ");
		    	
		    	int count = 0;
		    	for(int i = 0;i<companies.size();i++){
		    		if(!companies.get(i).application_status){
		    			count++;
		    			System.out.println(companies.get(i).name);
		    			companies.remove(i);
		    		}
		    	}
		    	if(count == 0){
		    		System.out.println("No Company");
		    	}
	    	}
	    	
	    	//query 4
	    	if(query ==4){
	    		int count = 0;
	    		for(int i = 0;i<students.size();i++){
	    			if(!students.get(i).placement_status){
		    			count++;
		    		}
	    		}
	    		if(count!=0){
	    			System.out.println(count + " students are left");
	    		}else{
	    			System.out.println("No students are left");
	    		}
	    		
	    	}
	    	
	    	//query 5
	    	if(query == 5){
	    		
	    		int count = 0;
	    		for(int i = 0;i<companies.size();i++){ 
	    			if(companies.get(i).application_status){
	    				count++;
	    				System.out.println(companies.get(i).name);
	    			}
	    		}
	    		
	    		if(count ==0){
	    			System.out.println("No openings in any company");
	    		}
	    	}
	    	
	    	//query 6
	    	if(query == 6){
	    		String name = in.next();
	    		ArrayList<String> a = new ArrayList<String>();
	    		company temp = new company("",a,0);
	    		int flag = 0;
	    		for(int i = 0;i<companies.size();i++){
	    			if(companies.get(i).name.equals(name)){
	    				temp = companies.get(i);
	    				flag = 1;
	    			}
	    		}
	    		
	    		if(flag == 1){
	    				boolean has_selected = false;
	    			    		if(temp.available_students.size() < temp.students_required){
	    			    			for(int i=0;i<temp.available_students.size();i++){
	    			    				
	    			    				int index = -1;
	    			    				for(int j = 0;j<students.size();j++){
	    			    					if(students.get(i).roll_no == temp.available_students.get(i).roll_no && !students.get(j).placement_status ){
	    			    						index = j;
	    			    						break;
	    			    					}
	    			    				}
	    			    				
	    			    				if(index != -1){
			    			    			students.get(index).placed_at = temp.name;
			    			    			students.get(index).placement_status = true;
			    			    			temp.selected_students.add(students.get(index));
			    			    	    	students_placed--;
			    			    	    	has_selected = true;
	    			    				}else{
	    			    					System.out.println("No available students");
	    			    				}
	    			    			}
	    			    			temp.students_required = temp.students_required - temp.available_students.size();
	    			    		}else{
	    			    				
	    			    			for(int i = 0;i<temp.students_required;i++){
	    			    				
	    			    				int index = -1;
	    			    				for(int j = 0;j<students.size();j++){
	    			    					if(students.get(j).roll_no == temp.available_students.get(i).roll_no && !students.get(j).placement_status){
	    			    						index = j;
	    			    						break;
	    			    					}
	    			    				}
	    			    				if(index!=-1){
		    			    				students.get(index).placed_at = temp.name;
		    			    				students.get(index).placement_status = true;
		    			    				temp.selected_students.add(students.get(index));
		    			    		    	students_placed--;
			    			    	    	has_selected = true;

	    			    				}else{
	    			    					System.out.println("No available students");
	    			    				}

	    			
	    			
	    			    			}
	    			    			temp.application_status = false;
	    			    			temp.students_required = 0;
	    			    			
	    			    			for(int i = 0;i<companies.size();i++){
	    			    				if(companies.get(i).name.equals(temp.name)){
	    			    					companies.set(i,temp);
	    			    				}
	    			    			}
	    			    		}
	    			    		if(has_selected){
		    			    		System.out.println("Roll no of selected student");
		    			    		for(int i = 0;i<temp.selected_students.size();i++){
		    			    			System.out.println(temp.selected_students.get(i).roll_no);
		    			    		}
	    			    		}
	    			
	    		}else{
	    			System.out.println("Enter Valid company name");
	    		}
	    		
	    	}
	    	
	    	//query 7
	    	if(query == 7){
	    		String name = in.next();
	    		
	    		for(int i = 0;i<companies.size();i++){
	    			if(companies.get(i).name.equals(name)){
	    				System.out.println(companies.get(i).name);
	    				System.out.println("Course Criteria");
	    				for(int j = 0;j<companies.get(i).branches_count;j++){
	    					System.out.println(companies.get(i).eligible_branches.get(j));
	    				}
	    				
	    				System.out.println("Number of required students = " + companies.get(i).students_required);
	    				if(companies.get(i).application_status){
	    					System.out.println("Application status - OPEN");
	    				}else{
	    					System.out.println("Application status - CLOSED");
	    				}
	    				break;
	    			}
	    		}
	    	}
	    	
	    	
	    	//query 8
	    	if(query == 8){
	    		int roll_no = in.nextInt();
	    		int index = -1;
	    		for(int i = 0;i<students.size();i++){
	    			if(students.get(i).roll_no == roll_no){
	    				index = i;
	    				break;
	    			}
	    		}
	    		if(index != -1){
		    		System.out.println(roll_no);
		    		System.out.println(students.get(index).cgpa);
		    		System.out.println(students.get(index).branch);
		    		if(students.get(index).placement_status){
		    			System.out.println("Placement status - Placed");
		    		}else{
		    			System.out.println("Placement status - Not Placed");
		    		}
	    		}else{
	    			System.out.println("Student not present in database");
	    		}
	    	}
	    	
	    	//query 9
	    	if(query == 9){
	    		
	    		int roll_no = in.nextInt();
	    		int index = -1;
	    		for(int i = 0;i<students.size();i++){
	    			if(students.get(i).roll_no == roll_no){
	    				index = i;
	    				break;
	    			}
	    		}
	    		if(index>=0){
		    		for(int i = 0;i<students.get(roll_no-1).applied_for.size();i++){
		    			System.out.println(students.get(roll_no-1).applied_for.get(i).name + " " + students.get(roll_no-1).technical_scores.get(i));
		    		}
	    		}else{
	    			System.out.println("No student with the given roll number has an account");
	    		}
	    	}
    	}
    	
    	System.out.println("All students are placed");
    	
    } 
} 