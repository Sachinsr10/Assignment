Feature: Simple e commerce end to end flow 

Scenario Outline: Login to application 
	When User Navigate to LogIn Page 
	And User enters UserName <userName> and Password<password> 
	Then click on login button 
	
	Examples: 
		|userName             |password |
		|"sa12345@gmail.com"  |"sa12345" |
		
Scenario Outline: Add item to cart 
	Given User login with UserName <userName> and Password<password>  
	When user clicks on category<category> 
	Then user select the item 
	Then user add the item to cart with quantity<quantity> and size<size> 
	Examples: 
		|category    |quantity|size|userName             |password |
		| "T-shirts" |  "2"   |"M" | "sa12345@gmail.com"  |"sa12345" |

