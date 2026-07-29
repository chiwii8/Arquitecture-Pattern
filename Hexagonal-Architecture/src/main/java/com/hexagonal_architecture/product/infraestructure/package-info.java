/**
 * Infraestructure Layer - Hexagonal Architecture Blueprint
 *  * <p> This layer represents the world out of our application.
 *  There is management the technology, frameworks, communication and storage</p>
 *
 *  <pre>
 *      infrastructure/  → Frameworks, Drivers, and Tools (The Adapters).
 *      ├── inbound/     → Driving adapters (e.g., REST Controllers, GraphQL, Request/Response DTO,
 *      ├                                       Mapper Request/domain to Command/Response).
 *      └── outbound/    → Driven adapters (e.g., JPA Repositories, External APIs, Mapper domain/entity).
 *  </pre>
 *
 *  * <h2> Dependency Rules:</h2>
 *  <ul>
 *      <li> Depends of the domain and application layer to manage or implement her contracts </li>
 *      <li>The intern layers cannot depend on it</li>
 *  </ul>
 *
 *  * <h2>Content</h2>
 *  <ul>
 *      <li> {@code inbound/} - (Driver-Adapters) Adapters driver to the application(controllers, listeners).</li>
 *      <li> {@code outbound/} n- (Driven-Adapters) Adapters drive to the application(Repositories, JPA/Hibernate, exteral API).</li>
 *  </ul>
 */

package com.hexagonal_architecture.product.infraestructure;