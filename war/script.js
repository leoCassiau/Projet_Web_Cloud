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
    $http.post(
      "https://1-dot-projet-web-cloud.appspot.com/_ah/api/websitedisabilitiesendpoint/v1/websitedisabilities",
      websiteDisabilitie
    );
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
