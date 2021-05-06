<h1>Using docker</h1>

docker run  -e "vaccine.pincodes=411045" -e "vaccine.minAge=18"  nsalunke/vaccine-alert:latest

<h1>How to run the App Locally with JAR</h1>

java -jar vaccine-alert-0.0.1-SNAPSHOT.jar --vaccine.pincodes=411045 --vaccine.cost=FREE --vaccine.minAge=18

<h2>Parameter Formats</h2>

vaccine.pincodes: 411001,411002  
vaccine.type: COVAXIN/COVISHIELD/ANY  
vaccine.minAge: 18/45  
vaccine.cost: FREE/PAID/ANY

<h2>How would you be notified of the new slots ? </h2>

When you run this app locally as jar, You will resceive alarm sound when a vaccine is available for you criteria.  
After that, whenever there is a change in response - Addition of new vaccine slots or updates, you will receive new notification.  

You can keep the application running in the background 
