## Backend API Endpoints

base : localhost:8080/api/v1/

---

### User Routes 

<ul>

<li> /users GET all users</li>
<li> /users POST Request Body of a user</li>
<li> /users/{username} GET user by Id</li>
<li> /users/{username} PUT request body of a user</li>
<li> /users/{username} DELETE request body of a user</li>

</ul>

---

### Movie Routes 

<ul>

<li> /movie GET all movies</li>
<li> /movie POST Request Body of a movies</li>
<li> /movie/{mid} GET movie by Id</li>
<li> /movie/{mid} PUT request body of a movie</li>
<li> /movie/{mid} DELETE request body of a movie</li>

<br>    
<li> /movie/user/?username= GET all movies for a user given a username query param</li>
<li> /movie/user/?username= POST movie for a user given a username query param</li>

</ul>

---

### Studio Routes 

<ul>

<li> /studio GET all studios</li>
<li> /studio POST Request Body of a studios</li>
<li> /studio/{sid} GET studio by Id</li>
<li> /studio/{sid} PUT request body of a studio</li>
<li> /studio/{sid} DELETE request body of a studio</li>

<br>    
<li> /movie/studio/?mid= GET all movies for a studio</li>
<li> /movie/studio/?mid= POST movie for a studio</li>

</ul>

---

### Director Routes 

<ul>

<li> /director GET all directors</li>
<li> /director POST Request Body of a directors</li>
<li> /director/{did} GET director by Id</li>
<li> /director/{did} PUT request body of a director</li>
<li> /director/{did} DELETE request body of a director</li>

<br>    
<li> /movie/director/?mid= GET all movies for a director</li>
<li> /movie/director/?mid= POST movie for a director</li>

</ul>

---

### Cast Member Routes 

<ul>

<li> /castMember GET all castMembers</li>
<li> /castMember POST Request Body of a castMembers</li>
<li> /castMember/{cmid} GET castMember by Id</li>
<li> /castMember/{cmid} PUT request body of a castMember</li>
<li> /castMember/{cmid} DELETE request body of a castMember</li>

<br>    
<li> /movie/castMember/?mid= GET all movies for a castMember</li>
<li> /movie/castMember/?mid= POST movie for a castMember</li>

</ul>
