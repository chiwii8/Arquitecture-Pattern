/**
 * Product Module - Hexagonal Architecture Blueprint.
 * * <p>This module follows the Hexagonal Architecture (Ports and Adapters) pattern
 * to ensure a strict separation between core business logic and infrastructure technologies.</p>
 * * <h2>Directory Layout & Responsibilities:</h2>
 * <pre>
 * product/
 * ├── domain/          → Core business logic (The Hexagon Interior).
 * │   ├── model/       → Pure business entities and value objects.
 * │   └── ports/       → Inbound (Use Cases) and Outbound (SPI) interfaces.
 * │
 * ├── application/     → Application services (The Orchestration layer).
 * │                    → Implements inbound ports and coordinates the flow.
 * │
 * └── infrastructure/  → Frameworks, Drivers, and Tools (The Adapters).
 *   ├── inbound/     → Driving adapters (e.g., REST Controllers, GraphQL).
 *   └── outbound/    → Driven adapters (e.g., JPA Repositories, External APIs).
 * </pre>
 * * <h2>Strict Dependency Rule:</h2>
 * <p>Dependencies must always point inwards. <b>Domain</b> and <b>Application</b>
 * layers are completely decoupled from frameworks (like Spring or Hibernate).
 * <b>Infrastructure</b> depends on the inner layers to fulfill technical implementations.</p>
 *
 * <h2>Why Modularity? (Product vs. User Separation):</h2>
 * <p>Each high-level directory (like {@code product} and {@code user}) represents a distinct
 * <b>Bounded Context</b>. They are strictly segregated into independent directories for the
 * following architectural reasons:</p>
 * * <ul>
 * <li><b>High Cohesion & Low Coupling:</b> All code related to products stays inside the product
 * package. It does not mix with user logic.</li>
 *  * <li><b>Microservice Readiness:</b> By isolating each context completely (Domain, Application,
 * and Infrastructure). If we ever need to scale,
 * extracting {@code product} into a standalone microservice is as simple as moving the directory
 * to a new repository.</li>
 * * <li><b>Independent Domain Evolution:</b> The changes on a product behaves
 * without any risk of breaking the authentication or profile logic of the other entities.</li>
 * </ul>
 * * <h2>Inter-Context Communication Rule:</h2>
 * <p>If {@code product} ever needs information from {@code user}, it must <b>never</b> bypass boundaries
 * by calling the user database or internal entities directly. Instead, it must communicate through
 * an application service or by emitting domain events.</p>
 */

package com.hexagonal_architecture.product;

