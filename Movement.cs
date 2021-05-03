using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Movement : MonoBehaviour {
	private float player_Speed = 5.0f;
	public GameObject cameraPos;	
	private float jump_Height = 400f;
	//private float restricted = -8.7f;
	private bool isGrounded;
	public GameObject mushroom;
	public Animator anim;
	public GameObject Weapon;
	public bool control_Access = true;
	public AudioSource source;
	public AudioSource hit_box;

	// Use this for initialization
	void Start () {
		

		
	}
	
	// Update is called once per frame
	void Update () {
		Vector3 rotations = gameObject.transform.localScale;
		Vector3 player_position = transform.position;
		Vector3 player_limit = cameraPos.transform.position;
		if (control_Access == true)
		{
			//controller
			if (Input.GetKey(KeyCode.D))
			{
				Vector3 newpos = new Vector3(player_position.x + (player_Speed * Time.deltaTime), player_position.y, player_position.z);
				rotations.x = 1.71105f;
				transform.localScale = rotations;
				transform.position = newpos;
				//Debug.Log("if1 working working");
				anim.SetFloat("Movement", 2);




			}
			if (Input.GetKeyUp(KeyCode.D))
			{
				anim.SetFloat("Movement", 0);
			}
			if (Input.GetKeyDown(KeyCode.A))
			{
				rotations.x = -1.71105f;
				transform.localScale = rotations;
			}
			if (Input.GetKey(KeyCode.A))
			{
				if (player_position.x < (player_limit.x - 6.64))
				{

				}
				else
				{

					Vector3 newpos = new Vector3(player_position.x - (player_Speed * Time.deltaTime), player_position.y, player_position.z);

					transform.position = newpos;
					anim.SetFloat("Movement", 2);
					//Debug.Log("if2 working working");
				}

			}
			if (Input.GetKeyUp(KeyCode.A))
			{
				anim.SetFloat("Movement", 0);
			}
			if (Input.GetKeyDown(KeyCode.W) && isGrounded == true)
			{
				source.Play();				
				GetComponent<Rigidbody2D>().AddForce(Vector3.up * jump_Height);
				isGrounded = false;
				anim.SetFloat("Jump", 2);		

			}
			if (Input.GetKeyUp(KeyCode.W))
			{
				source.Stop();
				anim.SetFloat("Jump", 0);
			}
			if (Input.GetKeyDown(KeyCode.E))
			{
				anim.SetFloat("Shoot", 2);
			}
			if (Input.GetKeyUp(KeyCode.E))
			{
				float i = transform.position.x;
				float j = transform.position.y;
				anim.SetFloat("Shoot", 0);
				Instantiate(Weapon, transform.position, transform.rotation);

			}
		}
		//anim
		//direction of player
		//physics


	}
	void OnCollisionEnter2D (Collision2D collision)
    {
		Debug.Log("Touched" +collision.collider.name);
		if(collision.gameObject.tag == "ground")
        {
			isGrounded = true;
        }
		if (collision.gameObject.tag == "obstacle")
		{
			isGrounded = true;
		}
		/*if(collision.gameObject.tag == "reward_size")
        {
			Vector3 scales = gameObject.transform.localScale;
			Vector3 newScale = new Vector3(scales.x * 2, scales.y * 2, scales.z * 2);
			transform.localScale = newScale;
        }*/
		if(collision.gameObject.tag == "Finish")
        {
			StartCoroutine(Finishline());

        }
		if(collision.gameObject.tag == "boost")
        {
			hit_box.Play();
        }
    }
	IEnumerator Finishline()
    {
		SceneManager.LoadScene("WinningScreen");

		yield return 0;
    }
}
