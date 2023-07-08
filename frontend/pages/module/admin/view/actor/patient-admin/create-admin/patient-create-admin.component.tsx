import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {Dropdown} from 'primereact/dropdown';
import {TabView, TabPanel} from 'primereact/tabview';
import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {InputNumber, InputNumberChangeEvent} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {classNames} from 'primereact/utils';
import { InputTextarea } from 'primereact/inputtextarea';
import {AxiosResponse} from 'axios';
import React, {useEffect, useState} from 'react';
import {Calendar, CalendarChangeEvent} from 'primereact/calendar';
import { format } from 'date-fns';
import {InputNumberChangeEvent} from 'primereact/inputnumber';
import { InputSwitch } from "primereact/inputswitch";
import {MultiSelect} from "primereact/multiselect";
import {MessageService} from "/pages/controller/service/MessageService";
import {PatientService} from '/pages/controller/service/Patient.service';
import  {PatientDto}  from '/pages/controller/model/Patient.model';
import {GenderDto} from '/pages/controller/model/Gender.model';
import {GenderService} from '/pages/controller/service/Gender.service';
import {VilleDto} from '/pages/controller/model/Ville.model';
import {VilleService} from '/pages/controller/service/Ville.service';
const Create = ({visible, onClose, add, showToast, list}) => {

    const emptyItem = new PatientDto();
    const [items, setItems] = useState<PatientDto[]>([list]);
    const [item, setItem] = useState<PatientDto>(emptyItem);
    const [submitted, setSubmitted] = useState(false); const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);
    const [genders, setGenders] = useState<GenderDto[]>([]);
    type GenderResponse = AxiosResponse<GenderDto[]>;
    const [villes, setVilles] = useState<VilleDto[]>([]);
    type VilleResponse = AxiosResponse<VilleDto[]>;

    useEffect(() => {
        const fetchData = async () => {
            try {
                const [] = await Promise.all<>([
                ]);
            } catch (error) {
                console.error(error);
            }
        };
        fetchData();
    }, []);

    const onDropdownChange = (e, field) => {
        setItem((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onTabChange = (e: { index: number }) => { setActiveIndex(e.index); };

    const hideDialog = () => {
        setSubmitted(false);
        onClose();
    };

    const saveItem = async () => {
        setSubmitted(true);
        let _items = [...items];
        let _item = {...item};
        if (!_item.id) {
            const response = await PatientService.save(_item);
			_item.id = response.data.id;
            _items.push(_item);
            add(_item);
            MessageService.showToast(showToast, { severity: 'success', summary: 'Successful', detail: 'Patient Created', life: 3000 });
        }
        setItems(_items);
        onClose();
        setItem(emptyItem);
    };

    const onInputTextChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _item = {...item};
        _item[`${name}`] = val;
        setItem(_item);
    };

    const onInputDateChange = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
        let _item = { ...item};
        _item[`${name}`] = val;
        setItem(_item);
    };

    const onInputNumerChange = (e: InputNumberChangeEvent, name: string) => {
        const val = e.value === null ? null : +e.value;
        setItem((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onMultiSelectChange = (e, field) => {
      if (e && e.value && Array.isArray(e.value)) {
         const selectedValues = e.value.map(option => option && option.value);
         setItem(prevState => ({ ...prevState, [field]: selectedValues, }));
      }
    };

    const onBooleanInputChange = (e: any, name: string) => {
       const val = e.value;
       setItem((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} />
        <Button label="Save" icon="pi pi-check" text onClick={saveItem} /> < />
    );

return(
    <Dialog visible={visible} style={{width: '70vw'}} header="Patient" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header="Patient">
                <div className="formgrid grid">
                    <div className="field col-6">
                    <label htmlFor="ipp">Ipp</label>
                    <InputText id="ipp" value={item.ipp} onChange={(e) => onInputTextChange(e, 'ipp')} required autoFocus className={classNames({'p-invalid': submitted && !item.ipp})} />
                    {submitted && !item.ipp && <small className="p-invalid">Ipp is required.</small>}
                    </div>
                    <div className="field col-6">
                    <label htmlFor="email">Email</label>
                    <InputText id="email" value={item.email} onChange={(e) => onInputTextChange(e, 'email')} required autoFocus className={classNames({'p-invalid': submitted && !item.email})} />
                    {submitted && !item.email && <small className="p-invalid">Email is required.</small>}
                    </div>
                    <div className="field col-6">
                    <label htmlFor="cin">Cin</label>
                    <InputText id="cin" value={item.cin} onChange={(e) => onInputTextChange(e, 'cin')} required autoFocus className={classNames({'p-invalid': submitted && !item.cin})} />
                    {submitted && !item.cin && <small className="p-invalid">Cin is required.</small>}
                    </div>
                    <div className="field col-6">
                    <label htmlFor="nom">Nom</label>
                    <InputText id="nom" value={item.nom} onChange={(e) => onInputTextChange(e, 'nom')} required autoFocus className={classNames({'p-invalid': submitted && !item.nom})} />
                    {submitted && !item.nom && <small className="p-invalid">Nom is required.</small>}
                    </div>
                    <div className="field col-6">
                    <label htmlFor="prenom">Prenom</label>
                    <InputText id="prenom" value={item.prenom} onChange={(e) => onInputTextChange(e, 'prenom')} required autoFocus className={classNames({'p-invalid': submitted && !item.prenom})} />
                    {submitted && !item.prenom && <small className="p-invalid">Prenom is required.</small>}
                    </div>
                    <div className="field col-6">
                    <label htmlFor="age">Age</label>
                    <InputNumber id="age" value={item.age} onChange={(e) => onInputNumerChange(e, 'age')} />
                    </div>
                    <div className="field col-6">
                    <label htmlFor="ville">Ville</label>
                    <Dropdown  id="villeDropdown"  value={item.ville} options={villes} onChange={(e) => onDropdownChange(e, 'ville')}   placeholder="Sélectionnez un ville" filter filterPlaceholder="Rechercher un ville" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                    <label htmlFor="gender">Gender</label>
                    <Dropdown  id="genderDropdown"  value={item.gender} options={genders} onChange={(e) => onDropdownChange(e, 'gender')}   placeholder="Sélectionnez un gender" filter filterPlaceholder="Rechercher un gender" optionLabel="libelle" />
                    </div>
                </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Create;
