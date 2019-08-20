# Placement_Cell
This is a backend code for automating the placement procedure in colleges


Each student can register themselves only once, and they must provide their CGPA and their
branch name for registration. Your software must ensure that each student applicant is
registered with a unique roll number. Different possible branches are CSE, ECE, CSD, CSAM,
CSB and CSSS. A student might get a chance to appear in the technical round of all the
companies visiting the campus. Your software should allow storing the marks obtained by a
student in the technical round of different companies.
Every company has a different course criteria for shortlisting students for the technical round.
Any student who fits this criteria can automatically apply for that company and must give the
technical round for that company. When a company account is created by the placement office,
the office must also enter the score of each student in the technical round of that company.
A company can only recruit a fixed number of students, although this number could be different
for different companies. If fewer students are left in the placement process, then the company
will take all the remaining students. A company also has its application status as OPEN or
CLOSED.
The students are shortlisted by any company according to their CGPA and their score in the
technical round. The student with a higher score in the technical round is given preference over
the CGPA. If two students score equally in the technical round, then the student with the higher
CGPA is given preference. Assume that no two students can have the same score in technical
round as well as same CGPA.
Once a company has selected the required number of students, the applications for that
company closes. Later, the account is removed from the application by the placement office.
Once a student is placed, he/she can not apply anywhere else and that student’s account is
also removed by the placement office.
Your application must exit once all the students have been placed.
Following are the different kinds of queries that must be handled by the system:
1) Add company
Inputs: name, course criteria, number of required students
The course criteria input will be taken in the following manner: number of courses eligible
(say x), the next x strings will be the courses.
Display details of the company (Company Name, Course Criteria, Number of required
students, Application Status)
2) Remove the accounts of the placed students
Output: Display roll numbers of students whose accounts were removed
3) Remove the accounts of companies whose applications are closed
Output: Display name of companies whose accounts were removed
4) Display number of unplaced students

5) Display names of companies whose applications are open
6) Select students
Input: Company name
Output: Roll numbers of selected students
7) Display details of the company
Input: Company name
Output: Company Name, Course Criteria, Number of required students, Application
Status
8) Display details of the student
Input: Roll number
Output: Roll number, CGPA, Course, Placement Status, Company in which student is
placed (if not placed, display nothing)
9) Display names of companies for which the student has applied and their scores in
technical round of that company
Input: Roll number
