# PDF-GENRATER# PDF Generator

This project provides a REST API for generating PDF invoices based on the provided seller, buyer, and item details.

## API Endpoint

- **URL:** `http://localhost:8080/generate-pdf`
- **Method:** POST
- **Content-Type:** application/json

## Request Body

The request body should be a JSON object containing the following fields:

```json
{
  "seller": "Vikram Traders",
  "sellerGstin": "29A888X2235",
  "sellerAddress": "Mumbai, India",
  "buyer": "Adventure Tours",
  "buyerGstin": "77KJ435B67890",
  "buyerAddress": "Pune, India",
  "items": [
    {
      "name": "Mountain Bike",
      "quantity": "5 Nos",
      "rate": 25000.00,
      "amount": 125000.00
    },
    {
      "name": "Camping Tent",
      "quantity": "10 Nos",
      "rate": 1500.00,
      "amount": 15000.00
    },
    {
      "name": "Hiking Boots",
      "quantity": "15 Nos",
      "rate": 2000.00,
      "amount": 30000.00
    },
    {
      "name": "Sleeping Bag",
      "quantity": "8 Nos",
      "rate": 3000.00,
      "amount": 24000.00
    },
    {
      "name": "Portable Stove",
      "quantity": "6 Nos",
      "rate": 4500.00,
      "amount": 27000.00
    }
  ]
}
