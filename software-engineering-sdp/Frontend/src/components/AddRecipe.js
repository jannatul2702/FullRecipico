// Done by Zlatan

import React, { useState } from "react";
import "./Add.scss"



const Add = () => {
  const [showPopup, setShowPopup] = useState(false);
  const [recipeName, setRecipeName] = useState("");
  const [category, setCategory] = useState("");
  const [type, setType] = useState("");
  const [prepTime, setPrepTime] = useState("");
  const [portion, setPortion] = useState("");
  const [ingredients, setIngredients] = useState([]);
  const [difficulty, setDifficulty] = useState("");
  const [amount, setAmount] = useState("");
  const [amountUnit, setAmountUnit] = useState("");
  const [ingredientName, setIngredientName] = useState("");
  const [unitOptions, setUnitOptions] = useState([
    "l",
    "ml",
    "kg",
    "mg",
    "g",
    "tablespoon",
  ]);
  const [categoryOptions, setCategoryOptions] = useState([
    "Appetizer and snack",
    "Main dish",
    "Side dish",
    "Everyday cooking",
    "Fruits and vegetables",
    "Seafood",
    "Meat and poultry",
    "World cuisine",
    "Pasta and noodles",
    "Dessert",
    "Drinks",
    "Breakfast and brunch",
    "Salad",
    "Soup",
    "Bread",
  ]);
  const [typeOptions, setTypeOptions] = useState([
    "Default",
    "Egg-free",
    "Gluten-free",
    "Diabetic",
    "No sugar",
    "Red meat free",
    "Vegetarian",
    "Wheat-free",
  ]);

  const handleButtonClick = () => {
    setShowPopup(true);
  };

  const handlePopupClose = () => {
    setShowPopup(false);
  };

  const handleChoiceSelect = (choice, stateSetter) => {
    stateSetter(choice);
  };

  const handleAddIngredient = (name, amount, unit) => {
    const newIngredient = { name: name, amount: amount, unit: unit };
    setIngredients([...ingredients, newIngredient]);
    setAmount("");
    setAmountUnit("");
  };

  const handleRemoveIngredient = (index) => {
    const updatedIngredients = [...ingredients];
    updatedIngredients.splice(index, 1);
    setIngredients(updatedIngredients);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const recipe = {
      recipeName,
      category,
      type,
      prepTime,
      portion,
      ingredients,
      difficulty,
    };
    console.log(recipe); // for keeping track
    setRecipeName("");
    setCategory("");
    setType("");
    setPrepTime("");
    setPortion("");
    setIngredients([]);
    setDifficulty("");
    setIngredientName("");
    setAmount("");
    setAmountUnit("");
  };

  return (
    <>
    <div>
      <h2>Add Recipe</h2>
      <form onSubmit={handleSubmit}>
        <div className="input-group">
          <label>
            Recipe Name:
            <input
              type="text"
              placeholder="Input name"
              value={recipeName}
              onChange={(e) => setRecipeName(e.target.value)}
              className="input-field"
            />
          </label>
        </div>

        <div className="input-group">
          <label>
            Category:
            <select
              value={category}
              placeholder="Preparation time"
              onChange={(e) => setCategory(e.target.value)}
            >
              <option value="">Select Category</option>
              {categoryOptions.map((option) => (
                <option key={option} value={option}>
                  {option}
                </option>
              ))}
            </select>
          </label>
        </div>

        <div className="input-group">
          <label>
            Type:
            <select
              value={type}
              placeholder="Preparation time"
              onChange={(e) => setType(e.target.value)}
            >
              <option value="">Select Type</option>
              {typeOptions.map((option) => (
                <option key={option} value={option}>
                  {option}
                </option>
              ))}
            </select>
          </label>
        </div>

        <div className="input-group">
          <label>
            Prep Time:
            <input
              type="text"
              placeholder="Preparation time"
              value={prepTime}
              onChange={(e) => setPrepTime(e.target.value)}
              className="input-field"
            />
          </label>
        </div>

        <div className="input-group">
          <label>
            Portion:
            <input
              type="number"
              placeholder="Portion size"
              value={portion}
              onChange={(e) => setPortion(e.target.value)}
              className="input-field"
            />
          </label>
        </div>

        <div className="input-group">
          <label>
            Difficulty:
            <select
              value={difficulty}
              onChange={(e) => setDifficulty(e.target.value)}
              className="input-field"
            >
              <option value="">Select Difficulty</option>
              <option value="easy">Easy</option>
              <option value="medium">Medium</option>
              <option value="hard">Hard</option>
            </select>
          </label>
        </div>

        <div className="input-group">
          <label>
            Ingredients:
            <div>
              <input
                type="text"
                placeholder="Ingredient name"
                value={ingredients.name}
                className="input-field"
                onChange={(e) => handleChoiceSelect(e.target.value, setIngredientName.name)}
              />
            </div>
            <div>
              <input
                type="number"
                placeholder="Amount"
                value={amount}
                onChange={(e) => setAmount(e.target.value)}
                className="input-field"
              />
              <select
                value={amountUnit}
                onChange={(e) => setAmountUnit(e.target.value)}
                className="input-field"
              >
                <option value="">Select Unit</option>
                {unitOptions.map((unit) => (
                  <option key={unit} value={unit}>
                    {unit}
                  </option>
                ))}
              </select>
              <button
                type="button"
                onClick={() => handleAddIngredient(ingredients.name, amount, amountUnit)}
                className="input-field"
              >
                Add Ingredient
              </button>
            </div>
          </label>
        </div>

        <ul>
          {ingredients.map((ingredient, index) => (
            <li key={index}>
              {ingredient.name} - {ingredient.amount} {ingredient.unit}
              <button
                type="button"
                onClick={() => handleRemoveIngredient(index)}
              >
                Remove
              </button>
            </li>
          ))}
        </ul>

        <button type="submit">Submit Recipe</button>
      </form>
    </div>
    </>
  );
};

export default Add;