
# mifosx-ai

Mifos X AI improves the experience of users implementing LLMs, Vector Search and Retrieval-Augmented Generation (RAG) for the Mifos platform.

This repository is in an early stage. The main goal is to provide connectors, example flows, and developer tools to integrate LLMs and vector stores with Mifos X features.

## Quick start (local)

Prerequisites
- Java 21 (use the included Maven wrapper to keep Maven consistent)
- Git
- (Optional) An LLM provider API key or a local Ollama server if you want to test real LLM calls
- (Optional) A vector DB endpoint for vector search

1. Clone the repo
   git clone https://github.com/openMF/mifosx-ai.git
   cd mifosx-ai

2. Build
   ./mvnw -B clean package

3. Run (local profile)
   ./mvnw spring-boot:run -Dspring-boot.run.profiles=local

4. Environment variables
   Copy the example .env.example and set your keys:
   cp .env.example .env
   Edit .env with your provider values (OPENAI_API_KEY, OLLAMA_URL, VECTOR_DB_URL, etc).

5. Test a simple endpoint
   (Replace SERVER_PORT if configured differently)
   curl -v http://localhost:8080/actuator/health

   If the project exposes AI endpoints, the README will be updated with example curl requests once those endpoints are available.

## Development notes

- Use the Maven wrapper: ./mvnw
- Run tests: ./mvnw test
- Use the `local` profile or a `test` profile that uses in-memory/mocked vector stores for CI and development.

## Suggested early contributions (good first tasks)
- Add a full quickstart README (this file) — done.
- Add CONTRIBUTING.md and issue/PR templates.
- Add a simple health-check endpoint for AI dependencies (vector DB, LLM).
- Add an in-memory vector store implementation to allow running RAG flows without external infra.
- Add CI (GitHub Actions) to run tests on PRs.

## Where to go next
- Check the repo issues, pick a small doc/CI/health check task, and open a focused PR.
- If you’re unsure about a larger change, open an issue describing the plan first to get feedback.

## License
MPL-2.0 (See repository license)
