# SBPOC

Basic Authentication in headers :
Content-Type:application/json
Authorization:Basic YWRtaW46cGFzc3dvcmQ=


#Ability to display top N and Bottom n plants in either ASC or DSC order by total generation output
http://localhost:8080/dubaiplants/getplants?id=desc
http://localhost:8080/dubaiplants/getplants?id=asc

#Get plants by location with pagination
http://localhost:8080/dubaiplants/getplantsByLocation?location=AK
http://localhost:8080/dubaiplants/getplantsByLocation?location=AK&limit=2

#Get plant details of a single powerplant
http://localhost:8080/dubaiplants/getplantdetails?plantname=Ambler

#creation of plants
http://localhost:8080/plants

Payload : 
{
	
	"year": "2019",
	"plant": "AK",
	"plantname": "Ambler",
	"genid": "2",
	"genstat": "OP",
	"genntan": "321"

}

#GetallPlants
http://localhost:8080/getAllPlants
