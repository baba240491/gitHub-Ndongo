import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { subscribeOn } from 'rxjs';


//metadonne
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent   {
  temperature : any ;
  pression : any ;
  pays : any ;
  ville : any ="Dakar";
  tempMax :any ;
  tempMin : any ;
  weatherData : any ;
  code : any ;
  vent : any ;

constructor(private httpclient : HttpClient){
  this.getweatherData() ;
  this.ville ='' ;
}

getweatherData(){
  this.httpclient.get(`https://api.openweathermap.org/data/2.5/weather?q=${this.ville}&appid=79249c8f73438bf45c18f85ae9380636`)
  .subscribe((Response)=>{
this.weatherData = Response ;
this.pays = this.weatherData['sys']['country'];
this.ville = this.weatherData['name'];
this.temperature=this.weatherData['main']['temp'];
this.pression =this.weatherData['main']['pressure'];
this.tempMax = this.weatherData['main']['temp_max'];
this.tempMin =this.weatherData['main']['temp_min'];
this.code = this.weatherData['weather']['0']['description'];
this.vent =this.weatherData['wind']['speed']


  },(error)=>{
      console.log("erreur");

  }


  );

}

  }


