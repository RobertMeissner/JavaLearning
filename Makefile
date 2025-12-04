.PHONY: frontend

frontend:
	cd apps/frontend && bun run start


test:
	cd apps/frontend && bun run test