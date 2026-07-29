/**
 * Application Layer - Hexagonal Architecture Blueprint
 *  * <p> This layer represents the Logic of our application.
 *  There is management the interactions with the Infrastructure layer and Domain layer</p>
 *
 *  <pre>
 *      application/  → Frameworks, Drivers, and Tools (The Adapters).
 *      ├── command/     → Represents the Pure Java records to translate the information from the Endpoints requests
 *      └── services/    → Business logic inte
 *  </pre>
 *
 *  * <h2> Dependency Rules:</h2>
 *  <ul>
 *      <li> Depends of the domain  layer to manage or implement her contracts </li>
 *      <li>The infrastructure layers should depend on it</li>
 *  </ul>
 *
 *  * <h2>Content</h2>
 *  <ul>
 *      <li> {@code command/} - Java records to the application(DTOs).</li>
 *      <li> {@code services/} n- Implement the business logic and verify the data.</li>
 *  </ul>
 */
package com.hexagonal_architecture.product.application;