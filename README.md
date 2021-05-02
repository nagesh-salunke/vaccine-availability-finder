<h1>Using docker</h1>

docker run  -e "vaccine.pincodes=411045" -e "vaccine.minAge=18"  nsalunke/vaccine-alert:latest

<h1>How to run the App Locally with JAR</h1>

java -jar vaccine-alert-0.0.1-SNAPSHOT.jar --vaccine.pincodes=411045 --vaccine.cost=FREE --vaccine.minAge=18

<h2>Parameter Formats</h2>

vaccine.pincode: 411001,411002  
vaccine.type: COVAXIN/COVISHIELD/ANY  
vaccine.minAge: 18/45  
vaccine.cost: FREE/PAID/ANY
