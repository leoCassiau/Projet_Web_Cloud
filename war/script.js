var app = angular.module('DisabilitiesResearch', []);

var disabilities = [
    "Dyslexia",
    "Dysgraphia",
    "Dyscalculia",
    "AttentionDeficitDisorder",
    "AspergerSyndrome",
    "ColourdBrlind",
    "PartiallySighted",
    "Blind",
    "HearingImparment",
    "Deaf",
    "UpperLimbsMobility",
    "LowerLimbsMobility",
    "ManuelDexterity",
    "CoordinationDifficulties",
    "Asthma",
    "Epilepsy",
    "Diabetes",
    "PostTraumaticStressDisorder",
    "Schizophrenia",
    "EatingDisorders",
    "Anxiety",
    "ObesessiveCompulsiveDisorder",
    "ManicDepression",
    "Phobia",
    "AutisticSpectrumDisorder",
    "Depression"];

(function() {
	  //var cx = '000659545447336849947:7ifptbpizio';
    var cref = 'http://1-dot-projet-web-cloud.appspot.com/CSEContext.xml';
		var gcse = document.createElement('script');
    gcse.type = 'text/javascript';
		gcse.async = true;
		//gcse.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') +
		//    '//cse.google.com/cse.js?cx=' + cx;
		gcse.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') +
		  '//cse.google.com/cse.js?cref=' + cref;
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(gcse, s);
	})();

app.controller('ResearchController', function($scope, $http){
  
  $scope.disabilities = disabilities;
  
  $scope.searchBar = function(disabilitie) {
	  $http.post("http://1-dot-projet-web-cloud.appspot.com/CSEContext.xml", 
	    { "disabilitie": disabilitie }).success();
	};
});

app.controller('addURLController', function($scope, $http){
  
  $scope.disabilities = disabilities;
  
  $scope.soumettre = function(websiteDisabilitie) {
	    var websiteDisabilitie;
	    var checkboxes = document.getElementsByName("disabilitie");
	    var url = document.getElementsByName("url")[0].value;
	    websiteDisabilitie = "url : "+url;
	    for (var i = 0; i < checkboxes.length; i++)  { 
	        var checkbox = checkboxes[i];  
	        if(checkbox.checked){ 
	            switch(i){
	            case 0 : 
	                websiteDisabilitie = websiteDisabilitie + ", Dyslexia:True";
	                break;
	            case 1 :
	                websiteDisabilitie = websiteDisabilitie + ", Dysgraphia:True";
	                break;
	            case 2 :
	                websiteDisabilitie = websiteDisabilitie + ", Dyscalculia:True";
	                break;
	            case 3 :
	                websiteDisabilitie = websiteDisabilitie + ", AttentionDeficitDisorder:True";
	                break;
	            case 4 :
	                websiteDisabilitie = websiteDisabilitie + ", AspergerSyndrome:True";
	                break;
	            case 5 :
	                websiteDisabilitie = websiteDisabilitie + ", ColourdBrlind:True";
	                break;            
	            case 6 :
	                websiteDisabilitie = websiteDisabilitie + ", PartiallySighted:True";
	                break;
	            case 7 : 
	                websiteDisabilitie = websiteDisabilitie + ", Blind:True";
	                break;
	            case 8 :
	                websiteDisabilitie = websiteDisabilitie + ", HearingImparment:True";
	                break;
	            case 9 :
	                websiteDisabilitie = websiteDisabilitie + ", Deaf:True";
	                break;
	            case 10 :
	                websiteDisabilitie = websiteDisabilitie + ", UpperLimbsMobility:True";
	                break;
	            case 11 :
	                websiteDisabilitie = websiteDisabilitie + ", LowerLimbsMobility:True";
	                break;            
	            case 12 :
	                websiteDisabilitie = websiteDisabilitie + ", ManuelDexterity:True";
	                break;  
	            case 13 : 
	                websiteDisabilitie = websiteDisabilitie + ", CoordinationDifficulties:True";
	                break;
	            case 14 :
	                websiteDisabilitie = websiteDisabilitie + ", Asthma:True";
	                break;
	            case 15 :
	                websiteDisabilitie = websiteDisabilitie + ", Epilepsy:True";
	                break;
	            case 16 :
	                websiteDisabilitie = websiteDisabilitie + ", Diabetes:True";
	                break;
	            case 17 :
	                websiteDisabilitie = websiteDisabilitie + ", PostTraumaticStressDisorder:True";
	                break;            
	            case 18 :
	                websiteDisabilitie = websiteDisabilitie + ", Schizophrenia:True";
	                break;
	            case 19 : 
	                websiteDisabilitie = websiteDisabilitie + ", EatingDisorders:True";
	                break;
	            case 20 :
	                websiteDisabilitie = websiteDisabilitie + ", Anxiety:True";
	                break;
	            case 21 :
	                websiteDisabilitie = websiteDisabilitie + ", ObesessiveCompulsiveDisorder:True";
	                break;
	            case 22 :
	                websiteDisabilitie = websiteDisabilitie + ", ManicDepression:True";
	                break;
	            case 23 :
	                websiteDisabilitie = websiteDisabilitie + ", Phobia:True";
	                break;            
	            case 24 :
	                websiteDisabilitie = websiteDisabilitie + ", AutisticSpectrumDisorder:True";
	                break;
	            case 25 :
	                websiteDisabilitie = websiteDisabilitie + ", Depression:True";
	                break;          
	            default :
	                break;
	            } 
	        }  
	    }
	    $http.post(
	      "https://1-dot-projet-web-cloud.appspot.com/_ah/api/websitedisabilitiesendpoint/v1/websitedisabilities",
	      websiteDisabilitie
	    );
	    document.write(websiteDisabilitie);
  }
  
  $scope.soumettreOLD = function() {
		var header = "Content-Type: text/xml \
      Authorization: GoogleLogin auth='1cf8bed212a990d4a15ceb84d84eba7276dde5d6'";
		var data2 = "\
	    <Batch> \
	      <Add> \
	        <Annotations> \
            <Annotation about='www.cnn.com'> \
              <Label name='_csefeed_7ifptbpizio'/> \
            </Annotation> \
          </Annotations> \
        </Add> \
      </Batch>";
	  $http.get("http://cse.google.com/api/default/annotations/7ifptbpizio", {
	    headers: {
        "Authorization": "GoogleLogin auth=1013514650190-bgu0rdsvueeve7gmberjjnuush7saf7m.apps.googleusercontent.com"
	    }
    }).then(function(response) {
      console.log("OUI");
	    $scope.tutu = response;
	  },function(response) {
	    console.log("NON");
	    console.log(response);
	    $scope.tutu = response;
	  });
  }
  
});
