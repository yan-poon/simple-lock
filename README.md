# Simple Lock

The primary objective of this project is to demonstrate the implementation and effectiveness of different locking strategies, specifically optimistic and pessimistic locking, in managing concurrent updates to coin prices in a multi-threaded environment. This is achieved through the development of a Java-based application that simulates concurrent updates to coin prices using threads.

## Key Features

- **Optimistic Locking**: Demonstrates how to handle concurrent updates by assuming that multiple transactions can complete without affecting each other and using versioning to prevent lost updates.
- **Pessimistic Locking**: Showcases a more traditional approach to handling concurrency, by locking the record for the exclusive use of a single transaction and thus preventing other transactions from accessing the locked record until the lock is released.

## Components

- **CoinPriceUpdateService**: A service layer that encapsulates the logic for updating coin prices using optimistic and pessimistic locking mechanisms.
- **OptimisticLockCoinPriceManager**: A component that manages the process of updating coin prices using an optimistic locking strategy, implemented as a `Runnable` to simulate concurrent updates in a multi-threaded scenario.
- **PessimisticLockCoinPriceManager**: Similar to `OptimisticLockCoinPriceManager`, but uses a pessimistic locking strategy to manage concurrent updates to coin prices.

This project serves as an educational tool for understanding the nuances of implementing optimistic and pessimistic locking strategies in Java applications, particularly in scenarios where data integrity and consistency are critical amidst concurrent operations.

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Before you begin, ensure you have the following installed:
- Java JDK 11 or newer
- Maven 3.6.3 or newer

### Installing

Follow these steps to get your development environment running:

1. Clone the repository

```bash
git clone https://github.com/yan-poon/simple-lock.git
```

2. Navigate to the project directory

```bash
cd simple-lock
```

3. Use Maven to install dependencies and build the project

```bash
mvn clean install
```

## Running the tests

Explain how to run the automated tests for this system.

```bash
mvn test
```

## Deployment

Add additional notes about how to deploy this on a live system.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Yan Poon** - *Initial work* - [yan-poon](https://github.com/yan-poon)

## License

This project is licensed under the MIT License - see the LICENSE.md file for details

## Acknowledgments