# brillio-meeting-app
Meeting Room booking app using Spring Boot and H2 data base
***Assumptions***
1.	Database will be prepopulated using the data.sql script by the Framework. It consists of Insert queries for 7 locations and 9 meeting rooms.
2.	It is assumed that the Response Format is basic minimal JSON.  As no formal specifications were given for the Response Body.
3.	No time slot attribute is considered for a meeting as it had no mention.
4.	Locations entered while adding a meeting room  should be in valid format.
5.	No separate Post requests handled to add a new Location, it can be added only while adding a Meeting Room.
6.	Get queries with ID should not pass a null ID.
7.	A booked MeetingRoom becomes available only in two cases - after Meeting cancellation or an API call to updateRoomStatus.


***Installation Guide and steps for Execution***
1. Install Java 8 and and update the jre/jdk path in environment variables
2. Intall Eclipse/STS(Spring Tool Suite)
3. Download and Install Postman App
4. Extract project zip and import in the workspace
5. Run BrillioBookMeetingRoomApplication class having the main method for the application.
6. Open Postman and paste the Swagger URL: 

	Hosted on Heroku - https://brillio-meeting-app.herokuapp.com/api/v1/meetingRoom/getRooms
	Heroku git URL - https://git.heroku.com/brillio-meeting-app.git
	Please checkout the below URLs for all details on API requests and responses 
		JSON Documentation    -  http://localhost:8083/api/v1/v2/api-docs
		Swagger Documentation -  http://localhost:8083/api/v1/swagger-ui.html#/

http://localhost:8083/api/v1/meetingRoom/getRooms
http://localhost:8083/api/v1/meeting/addMeeting/1
http://localhost:8083/api/v1/meetingRoom/addRoom

Add Meeting – Sample Request Body
{
    "name": "Araku",
    "status": "available",
    "type": "4",
    "location": {
    	"building" : "Building#21",
    	"floor" : "6"
    }
}
