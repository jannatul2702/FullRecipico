// Done by Momo

import React, { useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSearch, faBars } from '@fortawesome/free-solid-svg-icons';


const SearchBar = ({ onSearch }) => {
  const [query, setQuery] = useState("");
  const [recipes, setRecipes] = useState([]);
  const [alert, setAlert] = useState("");
  const [searchQuery, setSearchQuery] = useState('');
  const [selectedCategory, setSelectedCategory] = useState('');
  const [selectedType, setSelectedType] = useState('');
  const [selectedDifficulty, setSelectedDifficulty] = useState('');
  const [selectedPreparationTime, setSelectedPreparationTime] = useState('');
  const [categoriesOpen, setCategoriesOpen] = useState(false); // State to track the categories' open/close state

  const handleInputChange = (event) => {
    setSearchQuery(event.target.value);
  };

  const handleCategoryChange = (event) => {
    setSelectedCategory(event.target.value);
  };

  const handleTypeChange = (event) => {
    setSelectedType(event.target.value);
  };

  const handleDifficultyChange = (event) => {
    setSelectedDifficulty(event.target.value);
  };

  const handlePreparationTimeChange = (event) => {
    setSelectedPreparationTime(event.target.value);
  };

  const handleSearch = (event) => {
    event.preventDefault();
    onSearch(searchQuery, selectedCategory, selectedType, selectedDifficulty, selectedPreparationTime);
  };

  const handleCategoriesToggle = () => {
    setCategoriesOpen(!categoriesOpen);
  };

  return (
  
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', minHeight: '100vh', paddingTop: '20px' }}>
      <form onSubmit={handleSearch} style={{ display: 'flex', alignItems: 'center', marginBottom: '20px' }}>
        <button type="button" onClick={handleCategoriesToggle} style={{ marginRight: '10px', borderRadius: '50%', width: '50px', height: '50px' }}>
          <FontAwesomeIcon icon={faBars} size="lg" />
        </button>
        <input
          type="text"
          placeholder="SEARCH FOR A RECIPE OF YOUR CHOICE"
          value={searchQuery}
          onChange={handleInputChange}
          style={{ width: '400px', height: '40px', fontSize: '15px', borderRadius: '50px' }}
        />
        <button type="submit" style={{ marginLeft: '10px', borderRadius: '50%', width: '50px', height: '50px' }}>
          <FontAwesomeIcon icon={faSearch} size="lg" />
        </button>
      </form>

      {categoriesOpen && (
        <table style={{ marginTop: '20px' }}>
          <tbody>
            <tr>
              <td>Category:</td>
              <td>
                <select value={selectedCategory} onChange={handleCategoryChange}>
                  <option value="">All</option>
                  <option value="APPETIZER_AND_SNACK">Appetizer & Snack</option>
                  <option value="MAIN_DISH">Main Dish</option>
                  <option value="SIDE_DISH">Side Dish</option>
                  <option value="EVERYDAY_COOKING">Everyday Cooking</option>
                  <option value="FRUITS_AND_VEGETABLES">Fruits & Vegetables</option>
                  <option value="SEAFOOD">Seafood</option>
                  <option value="MEAT_AND_POULTRY">Meat & Poultry</option>
                  <option value="WORLD_CUISINE">World Cuisine</option>
                  <option value="PASTA_AND_NOODLES">Pasta & Noodles</option>
                  <option value="DESSERT">Dessert</option>
                  <option value="DRINKS">Drinks</option>
                  <option value="BREAKFAST_AND_BRUNCH">Breakfast & Brunch</option>
                  <option value="SALAD">Salad</option>
                  <option value="SOUP">Soup</option>
                  <option value="BREAD">Bread</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Type:</td>
              <td>
                <select value={selectedType} onChange={handleTypeChange}>
                  <option value="">All</option>
                  <option value="DEFAULT">Default</option>
                  <option value="EGG_FREE">Egg-Free</option>
                  <option value="GLUTEN_FREE">Gluten-Free</option>
                  <option value="DIABETIC">Diabetic</option>
                  <option value="NO_SUGAR">No Sugar</option>
                  <option value="RED_MEAT_FREE">Red Meat-Free</option>
                  <option value="VEGETARIAN">Vegetarian</option>
                  <option value="WHEAT_FREE">Wheat-Free</option>
                </select>
              </td> 
            </tr>
            <tr>
              <td>Difficulty:</td>
              <td>
                <select value={selectedDifficulty} onChange={handleDifficultyChange}>
                  <option value="">All</option>
                  <option value="EASY">Easy</option>
                  <option value="MODERATE">Moderate</option>
                  <option value="HARD">Hard</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Preparation Time:</td>
              <td>
                <select value={selectedPreparationTime} onChange={handlePreparationTimeChange}>
                  <option value="">All</option>
                  <option value="LESS_THAN_30_MIN">Less than 30 min</option>
                  <option value="LESS_THAN_1_HOUR">Less than 1 hour</option>
                  <option value="LESS_THAN_2_HOURS">Less than 2 hours</option>
                </select>
              </td>
            </tr>
          </tbody>
        </table>
      )}

        <div style={{ marginTop: '50px', textAlign: 'center', fontFamily: 'Bebas Neue, sans-serif', fontSize: '15px' }}>
        <p>BELOW ARE THE MOST POPULAR RECIPES:</p>
 
      </div>
    </div>
  );
};

export default SearchBar;
