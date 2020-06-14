# GIPHY Browser

Overview:

- Pretty standard overall architecture
  - View model with fragments
  - Repository for data loading
  - Dagger with Hilt for dependency injection
- Using retrofit to request GIPHY API directly
- Using pagination library for the list
- Fresco for image loading and caching

Limitations:

- Models don't have proper getters and setters to save time
- Should use parcelable instead of serializable for models
- Should separate model used for network layer from UI model
- Ideally add database for local storage
- There is no error handling for now; would need to propagate errors from data source all the way to UI
- Main fragment doesn't save state, so when you come back from details it resets
- Need to click twice of search icon to get to the search field
- Search field clearing doesn't work correctly
