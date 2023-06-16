const bodyParser = require('body-parser')
const mysql = require('mysql')
const express = require('express')
let app = express()



//les middalware pour les formulaire 
app.use(express.static('public'))                                      
app.use(bodyParser.urlencoded({extended:true}))

//les moteurs template 
app.set('views', './views')
app.set('view engine','ejs')

//connecter au BDD
const connection = mysql.createConnection({
    host : 'localhost',
    user : 'root',
    password : '',
    database : 'application'
});

    connection.connect((err,res)=>{
         if(err){
            console.log('non connecter a la BDD');
         }else{
            console.log('connecter au BDD');
         }
           
})
    

//les route

app.get('/user-new',(req, res)=>{
   res.render('new')
})

app.post('/user', (req, res)=>{
  console.log(req.body.nom+"   "+req.body.prenom+"    "+req.body.age)

})

//ajouter un utilisateur
app.post('/user-new', (req,res, next)=>{
   const postUpdate = {
         nom : req.body.nom ,
         prenom : req.body.prenom ,
         age: req.body.age 
   }
   let sql = "insert into utilisateur set ?";
   connection.query(sql ,postUpdate,(err, resultat)=>{
    if(err){
        console.log("err verifier la requette");
    }else{
        console.log("insertion reussit");

    }
    
   })

     connection.end();  
})

//afficher la liste des utilisateur 
app.get('/user', (req,res)=>{
    const postliste= {
        nom : req.body.nom ,
        prenom : req.body.prenom ,
        age: req.body.age 
  }
  let sql = "SELECT* FROM utilisateur";
  connection.query(sql ,postliste,(err, resultat)=>{
   if(err){
       console.log("err verifier la requette");
   }else{
      res.render('liste',{resultat})

   }
  
  })

    connection.end();    
})

//afficher les details
app.get('/user/:userId', (req, res) => {
    let user;
    const userId = req.params.userId
    for(let i=0; i<user.length; i++){
        if(userId == user[i].id){
            user = user[i]
        }
    }
    res.render('detail', {res})
})




       

//creer un serveur 
app.listen(9999,()=>{
    console.log('server connecter');


})




