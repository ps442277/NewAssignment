Feature: Get product information

Scenario Outline: Get information from the search result for Selected List
	Given User is on Homepage "<url>"
	When User Filter "<category>" and search for "<searchinput>"
	And Choose the "<list_number>" product from the list
	Then Get required information from the product into "<OutputRow>" row
Examples:
	|url				  |category |searchinput |list_number|OutputRow|
	|https://www.amazon.in|Books	|Data Catalog|	1		 |	2	   |
	|https://www.amazon.in|Books	|Data Catalog|	20		 |	3	   |