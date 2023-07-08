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
import {MultiSelect} from "primereact/multiselect";import {MessageService} from "/pages/controller/service/MessageService";

import {RendezVousService} from '/pages/controller/service/RendezVous.service';
import  {RendezVousDto}  from '/pages/controller/model/RendezVous.model';

import {EtatDoseDto} from '/pages/controller/model/EtatDose.model';
import {EtatDoseService} from '/pages/controller/service/EtatDose.service';
import {EffetIndesirableDto} from '/pages/controller/model/EffetIndesirable.model';
import {EffetIndesirableService} from '/pages/controller/service/EffetIndesirable.service';
import {CategorieRdvDto} from '/pages/controller/model/CategorieRdv.model';
import {CategorieRdvService} from '/pages/controller/service/CategorieRdv.service';
import {EtatRendezVousDto} from '/pages/controller/model/EtatRendezVous.model';
import {EtatRendezVousService} from '/pages/controller/service/EtatRendezVous.service';
import {CenterDto} from '/pages/controller/model/Center.model';
import {CenterService} from '/pages/controller/service/Center.service';
import {MedecinDto} from '/pages/controller/model/Medecin.model';
import {MedecinService} from '/pages/controller/service/Medecin.service';
import {PatientDto} from '/pages/controller/model/Patient.model';
import {PatientService} from '/pages/controller/service/Patient.service';
import {DoseDto} from '/pages/controller/model/Dose.model';
import {DoseService} from '/pages/controller/service/Dose.service';
const Edit = ({visible, onClose, showToast, selectedItem, update}) => {

    const emptyItem = new RendezVousDto();
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);
    const [item, setItem] = useState<RendezVousDto>( emptyItem);
    const [etatDoses, setEtatDoses] = useState<EtatDoseDto[]>([]);
    type EtatDoseResponse = AxiosResponse<EtatDoseDto[]>;
    const [effetIndesirables, setEffetIndesirables] = useState<EffetIndesirableDto[]>([]);
    type EffetIndesirableResponse = AxiosResponse<EffetIndesirableDto[]>;
    const [categorieRdvs, setCategorieRdvs] = useState<CategorieRdvDto[]>([]);
    type CategorieRdvResponse = AxiosResponse<CategorieRdvDto[]>;
    const [etatRendezVouss, setEtatRendezVouss] = useState<EtatRendezVousDto[]>([]);
    type EtatRendezVousResponse = AxiosResponse<EtatRendezVousDto[]>;
    const [centers, setCenters] = useState<CenterDto[]>([]);
    type CenterResponse = AxiosResponse<CenterDto[]>;
    const [medecins, setMedecins] = useState<MedecinDto[]>([]);
    type MedecinResponse = AxiosResponse<MedecinDto[]>;
    const [patients, setPatients] = useState<PatientDto[]>([]);
    type PatientResponse = AxiosResponse<PatientDto[]>;
    const [doses, setDoses] = useState<DoseDto[]>([]);
    type DoseResponse = AxiosResponse<DoseDto[]>;
    const [dose, setDose] = useState<DoseDto>(new DoseDto());
    const [effetIndesirable, setEffetIndesirable] = useState<EffetIndesirableDto>(new EffetIndesirableDto());

    useEffect(() => {
        const fetchData = async () => {
            try {
                // if pojo = Commande this line must dispolay client (in command), product(in commanandItem)
                const [medecinsResponse ,categorieRdvsResponse ,patientsResponse ,etatDosesResponse ,etatRendezVoussResponse ,centersResponse ] = await Promise.all<MedecinResponse,CategorieRdvResponse,PatientResponse,EtatDoseResponse,EtatRendezVousResponse,CenterResponse>([
                    MedecinService.getList(),
                    CategorieRdvService.getList(),
                    PatientService.getList(),
                    EtatDoseService.getList(),
                    EtatRendezVousService.getList(),
                    CenterService.getList(),
                ]);
                setMedecins(medecinsResponse.data);
                setCategorieRdvs(categorieRdvsResponse.data);
                setPatients(patientsResponse.data);
                setEtatDoses(etatDosesResponse.data);
                setEtatRendezVouss(etatRendezVoussResponse.data);
                setCenters(centersResponse.data);
            } catch (error) {
                console.error(error);
            }
        };
    fetchData();
    setItem(selectedItem ? { ...selectedItem } : { ...emptyItem });
    }, [selectedItem]);



    const onDropdownChange = (e, field) => {
        setItem((prevState) => ({ ...prevState, [field]: e.value, }));
    };

    const addDoses = () => {
        setSubmitted(true);
        if( item.doses == null )
        item.doses = new Array<DoseDto>();
        let _item = rendezVousItem;
        if (!_item.id) {
            item.doses.push(_item);
            MessageService.showToast(showToast, { severity: 'success', summary: 'Successful', detail: 'Dose Created', life: 3000 });
            setItem((prevState :any) => ({...prevState, doses: item.doses }));
        } else {
            const updatedItems = item.doses.map((item) => item.id === dose.id ? {...dose} : item);
            MessageService.showToast(showToast, { severity: 'success', summary: 'Successful', detail: 'Dose Updated', life: 3000 });
            setItem((prevState :any) => ({ ...prevState, doses: updatedItems}));
        }
        setDose(new DoseDto());
    };

    const deleteDose = (rowData) => {
        const updatedItems = item.doses.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, doses: updatedItems }));
        setRendezVousItem(new DoseDto());
        MessageService.showToast(showToast, {severity: 'success', summary: 'Successful', detail: 'RendezVousItem Deleted', life: 3000});
    };

    const editDose = (rowData) => {
        setActiveTab(0);
        setRendezVousItem(rowData);
    };

    const onInputNumerChangeDoses = (e, name) => {
        const val = e.value || 0;
        setDose((prevDoses) => ({ ...prevDoses, [name]: val, }));
    };

    const onMultiSelectChangeDoses = (e, field) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setDose(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChangeDoses = (e: any, name: string) => {
        const val = e.value;
        setDose((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangeDoses = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
        let _item = { ...dose};
        _item[`${name}`] = val;
        setDose(_item);
    };

    const onDropdownChangeDoses = (e, field) => {
        setDose((prevState) => ({ ...prevState, [field]: e.value}));
    };

    const onInputTextChangeDoses = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _item = {...dose};
        _item[`${name}`] = val;
        setDose(_item);
    };
    const addEffetIndesirables = () => {
        setSubmitted(true);
        if( item.effetIndesirables == null )
        item.effetIndesirables = new Array<EffetIndesirableDto>();
        let _item = rendezVousItem;
        if (!_item.id) {
            item.effetIndesirables.push(_item);
            MessageService.showToast(showToast, { severity: 'success', summary: 'Successful', detail: 'EffetIndesirable Created', life: 3000 });
            setItem((prevState :any) => ({...prevState, effetIndesirables: item.effetIndesirables }));
        } else {
            const updatedItems = item.effetIndesirables.map((item) => item.id === effetIndesirable.id ? {...effetIndesirable} : item);
            MessageService.showToast(showToast, { severity: 'success', summary: 'Successful', detail: 'EffetIndesirable Updated', life: 3000 });
            setItem((prevState :any) => ({ ...prevState, effetIndesirables: updatedItems}));
        }
        setEffetIndesirable(new EffetIndesirableDto());
    };

    const deleteEffetIndesirable = (rowData) => {
        const updatedItems = item.effetIndesirables.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, effetIndesirables: updatedItems }));
        setRendezVousItem(new EffetIndesirableDto());
        MessageService.showToast(showToast, {severity: 'success', summary: 'Successful', detail: 'RendezVousItem Deleted', life: 3000});
    };

    const editEffetIndesirable = (rowData) => {
        setActiveTab(0);
        setRendezVousItem(rowData);
    };

    const onInputNumerChangeEffetIndesirables = (e, name) => {
        const val = e.value || 0;
        setEffetIndesirable((prevEffetIndesirables) => ({ ...prevEffetIndesirables, [name]: val, }));
    };



    const onMultiSelectChangeEffetIndesirables = (e, field) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setEffetIndesirable(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChangeEffetIndesirables = (e: any, name: string) => {
        const val = e.value;
        setEffetIndesirable((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangeEffetIndesirables = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
        let _item = { ...effetIndesirable};
        _item[`${name}`] = val;
        setEffetIndesirable(_item);
    };

    const onDropdownChangeEffetIndesirables = (e, field) => {
        setEffetIndesirable((prevState) => ({ ...prevState, [field]: e.value}));
    };

    const onInputTextChangeEffetIndesirables = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _item = {...effetIndesirable};
        _item[`${name}`] = val;
        setEffetIndesirable(_item);
    };

    const onTabChange = (e: { index: number }) => {
        setActiveIndex(e.index);
    };

    const hideDialog = () => {
        setSubmitted(false);
        onClose();
    };

    const saveItem = async () => {
        setSubmitted(true);
        let _item = {...item};
        try {
            if (_item.id) {
                await RendezVousService.update(_item).then((response) => {
                    console.log(response.data);
                    update(response.data);
                    onClose();
                });
                MessageService.showToast(showToast, { severity: 'success', summary: 'Successful', detail: 'RendezVous Updated', life: 3000 });
            }
        } catch (error) {
            console.log(error);
            MessageService.showToast(showToast, { severity: 'Error', summary: 'Error', detail: 'Failed to save rendezVous', life: 3000 });
        }
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
    <Dialog visible={visible} style={{width: '70vw'}} header="RendezVous" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header="RendezVous">
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="patient">Patient</label>
                        <Dropdown  id="patientDropdown"  value={item ? item.patient : ''} options={patients} onChange={(e) => onDropdownChange(e, 'patient')}   placeholder="Sélectionnez un patient" filter filterPlaceholder="Rechercher un patient" optionLabel="email" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="center">Center</label>
                        <Dropdown  id="centerDropdown"  value={item ? item.center : ''} options={centers} onChange={(e) => onDropdownChange(e, 'center')}   placeholder="Sélectionnez un center" filter filterPlaceholder="Rechercher un center" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="medecin">Medecin</label>
                        <Dropdown  id="medecinDropdown"  value={item ? item.medecin : ''} options={medecins} onChange={(e) => onDropdownChange(e, 'medecin')}   placeholder="Sélectionnez un medecin" filter filterPlaceholder="Rechercher un medecin" optionLabel="email" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="datePriseRdv">DatePriseRdv</label>
                        <Calendar id="datePriseRdv" value={item ? item.datePriseRdv : ''} onChange={(e) => onInputDateChange(e, 'datePriseRdv')} dateFormat="dd/mm/yy" showTime />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="categorieRdv">CategorieRdv</label>
                        <Dropdown  id="categorieRdvDropdown"  value={item ? item.categorieRdv : ''} options={categorieRdvs} onChange={(e) => onDropdownChange(e, 'categorieRdv')}   placeholder="Sélectionnez un categorieRdv" filter filterPlaceholder="Rechercher un categorieRdv" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="etatRendezVous">EtatRendezVous</label>
                        <Dropdown  id="etatRendezVousDropdown"  value={item ? item.etatRendezVous : ''} options={etatRendezVouss} onChange={(e) => onDropdownChange(e, 'etatRendezVous')}   placeholder="Sélectionnez un etatRendezVous" filter filterPlaceholder="Rechercher un etatRendezVous" optionLabel="libelle" />
                    </div>
                </div>
            < /TabPanel>
            <TabPanel header="Doses">
                <TabView activeIndex={activeTab} onTabChange={(e) => setActiveTab(e.index)}>
                    <TabPanel header="Creation">
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="etatDose">Etat dose</label>
                                <Dropdown id="etatDoseDropdown" value={dose.etatDose} options={etatDoses} onChange={(e) => onDropdownChangeDoses(e, 'etatDose')} placeholder="Sélectionnez un etatDose" filter  filterPlaceholder="Rechercher un etatDose"  optionLabel="libelle" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="dateDebutPrevu">dateDebutPrevu</label>
                                <Calendar id="dateDebutPrevu" value={dose?.dateDebutPrevu}  onChange={(e) => onInputDateChangeDoses(e, 'doses')} dateFormat="dd/mm/yy" showTime  />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="dateDebutEffectif">dateDebutEffectif</label>
                                <Calendar id="dateDebutEffectif" value={dose?.dateDebutEffectif}  onChange={(e) => onInputDateChangeDoses(e, 'doses')} dateFormat="dd/mm/yy" showTime  />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="description">Description</label>
                                <InputText id="description" value={dose.description} onChange={(e) => onInputTextChangeDoses(e, 'doses')} required autoFocus className={classNames({'p-invalid': submitted && !item.doses})}/>
                            </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addDoses} />
                            </div>
                        </div>
                    </TabPanel>
                    <TabPanel header="Liste">
                        <div className="card">
                            <DataTable value={item.doses} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="etatDose.libelle" header="Etat dose"></Column>
                                <Column field="dateDebutPrevu" header="Date debut prevu"></Column>
                                <Column field="dateDebutEffectif" header="Date debut effectif"></Column>
                                <Column field="description" header="Description"></Column>
                                <Column header="Actions" body={(rowData) => (
                                    <div>
                                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deleteDose(rowData)} />
                                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editDose(rowData)} />
                                    </div>
                                )}></Column>
                            </DataTable>
                        </div>
                    </TabPanel>
                </TabView>
            </TabPanel>
            <TabPanel header="effetIndesirables">
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="dateFait">dateFait</label>
                                <Calendar id="dateFait" value={effetIndesirable?.dateFait}  onChange={(e) => onInputDateChangeEffetIndesirables(e, 'effetIndesirables')} dateFormat="dd/mm/yy" showTime  />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="description">Description</label>
                                <InputText id="description" value={effetIndesirable.description} onChange={(e) => onInputTextChangeEffetIndesirables(e, 'effetIndesirables')} required autoFocus className={classNames({'p-invalid': submitted && !item.effetIndesirables})}/>
                            </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addEffetIndesirables} />
                            </div>
                        </div>
                        <div class="p-col">
                        <div className="card">
                            <DataTable value={item.effetIndesirables} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="dateFait" header="Date fait"></Column>
                                <Column field="description" header="Description"></Column>
                                <Column header="Actions" body={(rowData) => (
                                    <div>
                                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deleteEffetIndesirable(rowData)} />
                                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editEffetIndesirable(rowData)} />
                                    </div>
                                )}></Column>
                            </DataTable>
                        </div>
                        </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Edit;


