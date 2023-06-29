# Recipico: Recipe Management System

## Database information

db info:

host: db.aowujnqrcjzmoexrizwy.supabase.co

db_name: postgres

port: 5432

user: postgres

password: 3v4AVNwH87q6CKVuuiUq

## How to connect with the backend?

### Requesting recipes

#### GET all recipes

HTTP request

```http
GET /recipes HTTP/1.1
Host: localhost:8080

```

React code using axios

```js
const RecipeList = () => {
  const [recipes, setRecipes] = useState([]);

  useEffect(() => {
    const fetchRecipes = async () => {
      try {
        const response = await axios.get('http://localhost:8080/recipes');
        setRecipes(response.data);
      } catch (error) {
        console.error('Error fetching recipes:', error);
      }
    };

    fetchRecipes();
  }, []);

  return (
    <div>
      <h1>Recipes</h1>
      <ul>
        {recipes.map((recipe) => (
          <li key={recipe.id}>{recipe.name}</li>
        ))}
      </ul>
    </div>
  );
};
```

Example of response:

```json
[
    {
        "categories": [],
        "ingredients": [
            {
                "ingredientId": 5,
                "ingredientName": "elbow macaroni",
                "proportionValue": 8.0,
                "proportionUnit": "ounce"
            },
            {
                "ingredientId": 6,
                "ingredientName": "butter",
                "proportionValue": 0.25,
                "proportionUnit": "cup"
            },
            {
                "ingredientId": 7,
                "ingredientName": "all-purpose flour",
                "proportionValue": 0.25,
                "proportionUnit": "cup"
            },
            {
                "ingredientId": 8,
                "ingredientName": "salt",
                "proportionValue": 0.5,
                "proportionUnit": "teaspoon"
            },
            {
                "ingredientId": 9,
                "ingredientName": "ground black pepper",
                "proportionValue": 0.125,
                "proportionUnit": "teaspoon"
            },
            {
                "ingredientId": 10,
                "ingredientName": "milk",
                "proportionValue": 2.0,
                "proportionUnit": "cup"
            },
            {
                "ingredientId": 11,
                "ingredientName": "shredded cheddar cheese",
                "proportionValue": 2.0,
                "proportionUnit": "cup"
            }
        ],
        "recipeId": 9,
        "recipeName": "Simple Macaroni and Cheese",
        "recipeDescription": "A very quick and easy fix to a tasty side-dish. Fancy, designer mac and cheese often costs forty or fifty dollars to prepare when you have so many exotic and expensive cheeses, but they aren't always the best tasting. This recipe is cheap and tasty.",
        "prepTime": "10 mins",
        "cookTime": null,
        "image_link": "https://www.allrecipes.com/thmb/xI5g0WBP8yPHwRt1Nt5WudTctzE=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/238691-Simple-Macaroni-And-Cheese-mfs_008-b32db5aa505041acbe958aedb81d29e9.jpg",
        "servings": 4,
        "difficulty": "Easy",
        "recipeType": "Default"
    }
]
```

#### GET specific recipe

HTTP Request

```http
GET /recipes/10 HTTP/1.1
Host: localhost:8080
```

React code using axios:

```js

const RecipeComponent = () => {
  const [recipe, setRecipe] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/recipes/10');
        setRecipe(response.data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      {recipe ? (
        <div>
          <h2>{recipe.title}</h2>
          <p>{recipe.description}</p>
          {/* Display other recipe data as needed */}
        </div>
      ) : (
        <p>Loading recipe...</p>
      )}
    </div>
  );
};
```

#### POST (Create) Recipe

```http
POST /recipes HTTP/1.1
Host: localhost:8080
userId: cf69e984-7985-4d75-8999-56b43f493426
Content-Type: application/json
Content-Length: 164

{
        "ingredients": [
            {
                "ingredientId": 7,
                "ingredientName": "all-purpose flour",
                "proportionValue": 0.25,
                "proportionUnit": "cup"
            }
        ],
        "recipeName": "Simple Pizza Recipe",
        "recipeDescription": "Put some water in the flour, tomato and cheese on top.",
        "prepTime": "30 mins",
        "image_link": "images/pizza.png",
        "servings": 2,
        "difficulty": "MODERATE",
        "recipeType": "VEGETARIAN"
}
```

React examples using axios

```js
class RecipeForm extends React.Component {
  handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const url = 'http://localhost:8080/recipes';
      const headers = {
        'userId': 'cf69e984-7985-4d75-8999-56b43f493426',
        'Content-Type': 'application/json'
      };
      const data = {
        ingredients: [
          {
            ingredientId: 7,
            ingredientName: 'all-purpose flour',
            proportionValue: 0.25,
            proportionUnit: 'cup'
          }
        ],
        recipeName: 'Simple Pizza Recipe',
        recipeDescription: 'Put some water in the flour, tomato and cheese on top.',
        prepTime: '30 mins',
        image_link: 'images/pizza.png',
        servings: 2,
        difficulty: 'MODERATE',
        recipeType: 'VEGETARIAN'
      };

      const response = await axios.post(url, data, { headers });
      console.log('Response:', response.data);
      // Handle the response as needed

    } catch (error) {
      console.error('Error:', error);
      // Handle the error
    }
  };

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        {/* Add your form fields here */}
        <button type="submit">Submit</button>
      </form>
    );
  }
}
```

#### PUT (Update) Recipe

```http
PUT /recipes/1 HTTP/1.1
Host: localhost:8080
userId: cf69e984-7985-4d75-8999-56b43f493426
Content-Type: application/json
Content-Length: 164

{
        "ingredients": [
            {
                "ingredientId": 7,
                "ingredientName": "all-purpose flour",
                "proportionValue": 0.25,
                "proportionUnit": "cup"
            }
        ],
        "recipeName": "Simple Pizza Recipe",
        "recipeDescription": "Put some water in the flour, tomato and cheese on top.",
        "prepTime": "30 mins",
        "image_link": "images/pizza.png",
        "servings": 2,
        "difficulty": "MODERATE",
        "recipeType": "VEGETARIAN"
}
```

#### DELETE Recipe

```http
DELETE /recipes/2 HTTP/1.1
Host: localhost:8080
userId: cf69e984-7985-4d75-8999-56b43f493426
```
