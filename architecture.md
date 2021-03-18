# **GROUP 3 - THRIVE ARCHITECTURE**

## Diagram
UI/Presentation
                   ┌───────────────┐     ┌──────────────────┐     ┌──────────────────┐            ┌──────────────────┐
                   │Login Activity │◄────┤Register Activity │     │Main Activity     │            │Workout Suggestion│
                   │               │     │                  │     │                  ├─────┬────► │                  │
                   │               │     │                  │     │                  │     │      │                  │
                   │               ├────►│                  │     │                  │     │      │                  │
                   └───────┬───────┘     └─────────┬────────┘     └───────┬──────────┘     │      └──────────────────┘
                           │                       │                   ▲  │                │
                           │                       │                   │  │                │       ┌─────────────────┐
                           ├───────────────────────┼───────────────────┘  │                │       │Blood Health     │
                           │                       │                      │                └────►  │ Optimizer       │
                           │                       │                      │                        │                 │
                           │                       │                      │                        │                 │
                           │                       │                      │                        └─────────────────┘
                           │                       │                      │                                            │
───────────────────────────┼───────────────────────┼──────────────────────┼────────────────────────────────────────────┘
                           │                       │                      │
Logic                      ▼                       ▼                      │
                   ┌───────────────┐      ┌─────────────────┐             │
                   │Login Manager  │      │Register Manager │             │
                   │               │      │                 │             │
                   │               │      │                 │             │
                   │               │      │                 │             │
                   └──────┬────────┘      └───────────┬─────┘             │
                          │                           │                   │                                             │
 ─────────────────────────┼───────────────────────────┼───────────────────┼─────────────────────────────────────────────┘
                          │                           │                   │
Data/Persistence          │       ┌─────────────┐     │                   │
                          │       │Database     │     │                   │
                          │       │  Interface  │     │                   │                     xxxxxxxxxxxxxxxx
                          │       └─────────────┘     │                   │                   xx               xxx
                          │                           │                   │                   x       DATA       x
                          │                           │                   │                   x                  x
                          │                           │                   │                   xx                xx
                          │       ┌─────────────┐     │                   │                     xxxx    ▲    xxxx
                          │       │Database     │◄────┘                   │                        xxxxx│xxxxx
                          └─────► │  Helper     │     ◄───────────────────┘                             │
                                  │             │                                                       │
                                  └─────────────┘◄──────────────────────────────────────────────────────┘

### UI/Presentation Layer
- LoginActivity
- RegisterActivity
- MainActivity
- WorkoutSuggestion
- GenderSelection
- ViewPDF
---
### Logic
- LoginManager
- RegisterManager
---
### Data/Persistence
- Database(Interface)
- DatabaseBasic (stub)
- DatabaseHelper (adapter)
- User
---


