# hoolah-code
	It is an maven project

Building :

- Set  JAVA_HOME. Java 1.8 	(Mine 1.8.0_231)
- Set Maven home.  Mine: Apache Maven 3.5.2 
- Download repository to your local
- Navigate to the path where pom.xml located
- Execute 
maven install 
- Jar will be generated under target

Running:
1. Navigate to target folder
java -jar TranStat-0.0.1-jar-with-dependencies.jar "full path of transaction CSV"
2. Key in Merchant, Start date and End date through command line

Sample output:

C:\Users\Naveen\git\hoolah-code\TranStat\target>java -jar TranStat-0.0.1-jar-with-dependencies.jar "C:\\Naveen\\NewJ\\Coding\\WS\\TranStat\\Files\\data.csv"
2019-11-15 01:06:32.392: CSV file is loaded
Enter merchant name:
Kwik-E-Mart
Enter Start date:
20/08/2018 12:45:33
Enter End date:
20/08/2018 13:14:11
2019-11-15 01:07:11.289: Generate Stats - Started
2019-11-15 01:07:11.301: Generate Stats - Ended
***
Merchant: Kwik-E-Mart
Total transactions: 2
Avearge amount: 32.5
***

