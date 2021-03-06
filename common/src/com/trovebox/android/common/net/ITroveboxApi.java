
package com.trovebox.android.common.net;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.content.Context;

import com.trovebox.android.common.net.HttpEntityWithProgress.ProgressListener;

public interface ITroveboxApi {

    /**
     * @return tags which are used on the server
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    TagsResponse getTags() throws ClientProtocolException, IOException,
            IllegalStateException, JSONException;

    /**
     * @return albums which are used on the server
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    AlbumsResponse getAlbums() throws ClientProtocolException, IOException,
            IllegalStateException, JSONException;

    /**
     * Get albums.
     * 
     * @param paging paging information
     * @param skipEmpty whether to do not return empty albums
     * @return albums which are used on the server
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    AlbumsResponse getAlbums(Paging paging, boolean skipEmpty)
            throws ClientProtocolException, IllegalStateException, IOException,
            JSONException;

    /**
     * Retrieve a single album.
     * 
     * @param albumId id of the album
     * @return the album
     * @throws IOException
     * @throws ClientProtocolException
     * @throws JSONException
     * @throws IllegalStateException
     */
    AlbumResponse getAlbum(String albumId) throws ClientProtocolException,
            IOException, IllegalStateException, JSONException;

    /**
     * Retrieve a single photo.
     * 
     * @param photoId id of the photo
     * @param returnSize which sizes should be returned
     * @param token access token for the photo if required
     * @param host alternate host
     * @return the photo
     * @throws IOException
     * @throws ClientProtocolException
     * @throws JSONException
     * @throws IllegalStateException
     */
    PhotoResponse getPhoto(String photoId, ReturnSizes returnSize, String token, String host)
            throws ClientProtocolException, IOException, IllegalStateException,
            JSONException;

    /**
     * Will return the URL to which the user has to start the OAuth
     * authorization process.
     * 
     * @param name Name of the app for which authorization is requested
     * @param callback Where the user should be forwarded after authorizing the
     *            app.
     * @param context
     * @return Url to which the user should be pointed in a WebView.
     */
    String getOAuthUrl(String name, String callback, Context context);

    /**
     * Get photos.
     * 
     * @return the photos
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getPhotos() throws ClientProtocolException,
            IllegalStateException, IOException, JSONException;

    /**
     * Get photos.
     * 
     * @param resize which sizes should be returned
     * @return the photos
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getPhotos(ReturnSizes resize)
            throws ClientProtocolException, IllegalStateException, IOException,
            JSONException;

    /**
     * Get photos.
     * 
     * @param resize which sizes should be returned
     * @param paging paging information
     * @return the photos
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getPhotos(ReturnSizes resize, Paging paging)
            throws ClientProtocolException, IllegalStateException, IOException,
            JSONException;

    /**
     * Get photos.
     * 
     * @param resize which sizes should be returned
     * @param tags filter potos by these tags
     * @param album filter potos by this album
     * @return the photos
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getPhotos(ReturnSizes resize, Collection<String> tags,
            String album)
            throws ClientProtocolException, IllegalStateException, IOException,
            JSONException;

    /**
     * Get photos.
     * 
     * @param resize which sizes should be returned
     * @param tags filter potos by these tags
     * @param album filter potos by this album
     * @param token access token for the album if required
     * @param sortBy sort photos condition
     * @param paging page and pageSize to be retrieved
     * @param host alternate host
     * @return the photos
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getPhotos(ReturnSizes resize, Collection<String> tags,
            String album,
            String token,
            String sortBy,
            Paging paging,
            String host) throws ClientProtocolException, IOException,
            IllegalStateException, JSONException;

    /**
     * Upload a picture.
     * 
     * @param imageFile the image file
     * @param metaData MetaData which define title, ... of the photo
     * @param progressListener Listener that will be called on progress
     * @return The response with which contains info about the uploaded photo
     * @throws IOException
     * @throws ClientProtocolException
     * @throws JSONException
     * @throws IllegalStateException
     */
    UploadResponse uploadPhoto(File imageFile, UploadMetaData metaData,
            ProgressListener progressListener) throws ClientProtocolException, IOException,
            IllegalStateException, JSONException;

    /**
     * Upload a picture.
     * 
     * @param imageFile the image file
     * @param metaData MetaData which define title, ... of the photo
     * @param token special upload token if present
     * @param host alternate upload host
     * @param progressListener Listener that will be called on progress
     * @return The response with which contains info about the uploaded photo
     * @throws IOException
     * @throws ClientProtocolException
     * @throws JSONException
     * @throws IllegalStateException
     */
    UploadResponse uploadPhoto(File imageFile, UploadMetaData metaData, String token, String host,
            ProgressListener progressListener) throws ClientProtocolException, IOException,
            IllegalStateException, JSONException;

    /**
     * Update a picture details.
     * 
     * @param photoId the id of the photo which should be updated
     * @param title the new title. Ignored if null.
     * @param description the new description. Ignored if null.
     * @param tags the new tags. Ignored if null.
     * @param permission permission information. Ignored if null.
     * @return The response which contains info about the updated photo
     * @throws IOException
     * @throws ClientProtocolException
     * @throws JSONException
     * @throws IllegalStateException
     */
    PhotoResponse updatePhotoDetails(String photoId,
            String title,
            String description,
            Collection<String> tags,
            Integer permission)
            throws ClientProtocolException,
            IOException, IllegalStateException, JSONException;

    /**
     * Return Newest Photos to be used in the Home Screen
     * 
     * @param paging paging for the newest hone screen
     * @return a list of photos to be displayed inthe home screen
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getNewestPhotos(Paging paging) throws ClientProtocolException, IOException,
            IllegalStateException, JSONException;

    /**
     * Return Newest Photos to be used in the Home Screen
     * 
     * @param resize which sizes should be returned
     * @param paging paging for the newest hone screen
     * @return a list of photos to be displayed inthe home screen
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getNewestPhotos(ReturnSizes resize, Paging paging)
            throws ClientProtocolException, IOException,
            IllegalStateException, JSONException;

    /**
     * Return the photos by given SHA-1 hash
     * 
     * @param hash
     * @return a list of photos with the specified hash
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getPhotos(String hash) throws ClientProtocolException,
            IOException, IllegalStateException,
            JSONException;

    /**
     * Delete the photo from the server by id
     * 
     * @param photoId id of the photo
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    public TroveboxResponse deletePhoto(String photoId) throws ClientProtocolException,
            IOException, IllegalStateException, JSONException;

    /**
     * Get the profile information
     * 
     * @param includeViewer whether to include viewer profile information
     * @return profile information
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    ProfileResponse getProfile(boolean includeViewer) throws ClientProtocolException, IOException,
            IllegalStateException, JSONException;

    /**
     * @return system version information
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    SystemVersionResponse getSystemVersion() throws ClientProtocolException, IOException,
            IllegalStateException, JSONException;

    /**
     * Create an album
     * 
     * @param name the album name
     * @return the created album information
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    AlbumResponse createAlbum(String name) throws ClientProtocolException, IOException,
            IllegalStateException, JSONException;

    /**
     * Create a share token for the photo
     * 
     * @param photoId an id of a photo the token should be created for
     * @return the created token information
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    TokenResponse createTokenForPhoto(String photoId) throws ClientProtocolException, IOException,
            IllegalStateException, JSONException;

    /**
     * Validate upload token
     * 
     * @param token the token to validate
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    TokenValidationResponse validateUploadToken(String token) throws ClientProtocolException,
            IOException, IllegalStateException, JSONException;

    /**
     * Notify upload finished event for the token
     * 
     * @param token the token uploads done for
     * @param host the alternate notify host
     * @param uploader the user name uploads was tagged with
     * @param count the successful uploads count
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    TroveboxResponse notifyUploadFinished(String token, String host, String uploader, int count)
            throws ClientProtocolException, IOException, IllegalStateException, JSONException;

}
